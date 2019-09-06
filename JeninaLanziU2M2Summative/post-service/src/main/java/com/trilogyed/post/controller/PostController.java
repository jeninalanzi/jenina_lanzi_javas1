package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CrossOrigin
public class PostController {

    @Autowired
    PostDao postDao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody @Valid Post post) {
        postDao.addPost(post);
        return postDao.getPost(post.getPostID());
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Post ID must be greater than 0!");
        }
        return postDao.getPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    public List<Post> getPostsByPoster(@PathVariable String posterName) {
        return postDao.getPostsByPoster(posterName);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        for (Post p : postDao.getAllPosts()) {
            if (p.getPostID() == id) {
                post.setPostID(id);
                postDao.updatePost(post);
            }
        }
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Post ID must be greater than 0!");
        }
        postDao.deletePost(id);
    }
}
