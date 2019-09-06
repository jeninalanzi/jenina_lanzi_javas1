package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.view.PostViewModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class StwitterServiceTest {

    PostServiceClient mockPostClient;
    CommentServiceClient mockCommentClient;
    ServiceLayer mockServiceLayer;

    @Before
    public void setUp() throws Exception {
        setUpPostClientMock();
        setUpCommentClientMock();
        mockServiceLayer = new ServiceLayer(mockCommentClient, mockPostClient);
    }

    // Test methods below.
    @Test
    public void saveFindPostViewModel() {
        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(2);
        pvm.setPostDate(LocalDate.of(2019, 8, 1));
        pvm.setPosterName("Sharon Q");
        pvm.setPost("I played Mario Party with my friends last night and it was so much fun!");

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2019, 8, 5));
        comment.setCommenterName("Benjamin");
        comment.setComment("This is a really fun video game!");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        pvm.setComments(commentList);

        pvm = mockServiceLayer.savePost(pvm);

        PostViewModel mockFromService = mockServiceLayer.findPost(pvm.getPostId());
        assertEquals(pvm, mockFromService);
    }



    // ------------------------------------------------------------------
    // Helper Methods

    private void setUpPostClientMock() {
        mockPostClient = mock(PostServiceClient.class);

        // Mock post
        Post post = new Post();
        post.setPostID(2);
        post.setPostDate(LocalDate.of(2019, 8, 1));
        post.setPosterName("Sharon Q");
        post.setPost("I played Mario Party with my friends last night and it was so much fun!");

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019, 8, 1));
        post1.setPosterName("Sharon Q");
        post1.setPost("I played Mario Party with my friends last night and it was so much fun!");

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(post).when(mockPostClient).createPost(post);
        doReturn(post).when(mockPostClient).getPost(2);
        doReturn(postList).when(mockPostClient).getAllPosts();

    }

    private void setUpCommentClientMock() {
        mockCommentClient = mock(CommentServiceClient.class);

        // Mock comment
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2019, 8, 5));
        comment.setCommenterName("Benjamin");
        comment.setComment("This is a really fun video game!");

        Comment comment1 = new Comment();
        comment1.setPostId(2);
        comment1.setCreateDate(LocalDate.of(2019, 8, 5));
        comment1.setCommenterName("Benjamin");
        comment1.setComment("This is a really fun video game!");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        doReturn(comment).when(mockCommentClient).createComment(comment1);
        doReturn(comment).when(mockCommentClient).getComment(1);
        doReturn(commentList).when(mockCommentClient).getAllComments();

    }

}
