package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.view.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

// This is the layer that the end users will interact with.
// All incoming data goes through the viewModel and gets filtered accordingly.

@Component
public class ServiceLayer {

    @Autowired
    private final CommentServiceClient commentClient;
    private final PostServiceClient postClient;

    @Autowired
    public ServiceLayer(CommentServiceClient commentClient, PostServiceClient postClient) {
        this.commentClient = commentClient;
        this.postClient = postClient;
    }


    public PostViewModel savePost(PostViewModel viewModel) {

        // Persist Post object
        Post p = new Post();
        p.setPostDate(viewModel.getPostDate());
        p.setPosterName(viewModel.getPosterName());
        p.setPost(viewModel.getPost());

        // Save post to Dao and obtain id.
        p = postClient.createPost(p);
        viewModel.setPostId(p.getPostID());

        System.out.println(p);
        return viewModel;
    }

    public PostViewModel findPost(int id) {
        Post post = postClient.getPost(id);
        return buildPostViewModel(post);
    }

    private PostViewModel buildPostViewModel(Post post) {

        // Get the associated post
        Post p = postClient.getPost(post.getPostID());

        // Get all associated comments with the post
        List<Comment> commentsList = commentClient.getCommentsByPost(p.getPostID());

        // Assemble the PostViewModel
        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(p.getPostID());
        pvm.setPostDate(p.getPostDate());
        pvm.setPosterName(p.getPosterName());
        pvm.setPost(p.getPost());
        pvm.setComments(commentsList);

        // Return the PostViewModel
        return pvm;
    }

    public List<PostViewModel> findAllPosts() {
        List<Post> postList = postClient.getAllPosts();

        List<PostViewModel> pvmList = new ArrayList<>();

        for (Post post : postList) {
            PostViewModel pvm = buildPostViewModel(post);
            pvmList.add(pvm);
        }

        return pvmList;
    }

    public List<PostViewModel> findPostsByPoster(String posterName) {
        List<Post> postsByPosterList = postClient.getPostsByPoster(posterName);

        List<PostViewModel> pvmList = new ArrayList<>();

        for (Post post : postsByPosterList) {
            PostViewModel pvm = buildPostViewModel(post);
            pvmList.add(pvm);
        }
        return pvmList;
    }

    public void updatePost(PostViewModel viewModel) {

        // Update post information
        Post post = new Post();
        post.setPostID(viewModel.getPostId());
        post.setPostDate(viewModel.getPostDate());
        post.setPosterName(viewModel.getPosterName());
        post.setPost(viewModel.getPost());

        List<Comment> commentList = commentClient.getCommentsByPost(post.getPostID());
        commentList.stream()
                .forEach(comment -> commentClient.deleteComment(comment.getCommentId()));

        List<Comment> comments = viewModel.getComments();
        comments.stream()
                .forEach(c -> {
                    c.setPostId(viewModel.getPostId());
                    c = commentClient.createComment(c);
                });

        System.out.println("Post #" + post.getPostID() + " successfully updated.");
    }

    public void removePost(int id) {

        // Remove all associated comments first.
        List<Comment> commentList = commentClient.getCommentsByPost(id);
        commentList.stream()
                .forEach(comment -> commentClient.deleteComment(comment.getCommentId()));

        // Remove the post entirely.
        postClient.deletePost(id);
    }

    // -----------------------------------------------------------------------------------------

    // Below are methods for being able to add Comments from the ServiceLayer.
    // At the end, comment is returned.
    public Comment addCommentToPost(Comment comment) {

        // Persist a comment object
        Comment newComment = new Comment();
        newComment.setPostId(comment.getPostId());
        newComment.setCreateDate(comment.getCreateDate());
        newComment.setCommenterName(comment.getCommenterName());
        newComment.setComment(comment.getComment());

        // Add to commentDao so it gets assigned a commentId.
        newComment = commentClient.createComment(newComment);
        comment.setCommentId(newComment.getCommentId());

        System.out.println("Comment id#" + comment.getCommentId() + " successfully added!");
        return newComment;
    }



    // -----------------------------------------------------------------------------------------
    // Comment API
    public Comment saveComment(Comment comment) { return commentClient.createComment(comment); }
    public Comment getComment(int commentId) { return commentClient.getComment(commentId); }
    public List<Comment> getAllComments() { return commentClient.getAllComments(); }
    public List<Comment> getCommentsByPost(int postId) { return commentClient.getCommentsByPost(postId); }
    public void updateComment(Comment comment) { commentClient.updateComment(comment.getCommentId(), comment); }
    public void deleteComment(int id) { commentClient.deleteComment(id); }

    // Post API
    public Post savePost(Post post) { return postClient.createPost(post); }
    public Post getPost(int id) { return postClient.getPost(id); }
    public List<Post> getAllPosts() { return postClient.getAllPosts(); }
    public List<Post> getPostsByPoster(String posterName) { return postClient.getPostsByPoster(posterName); }
    public void updatePost(Post post) { postClient.updatePost(post, post.getPostID()); }
    public void deletePost(int id) { postClient.deletePost(id); }
}
