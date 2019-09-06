package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.view.PostViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// This now has full access to all post-service controllers.

@FeignClient(name = "post-service")
public interface PostServiceClient {

    // Invoke .createPost() in THIS service's controller
    // to invoke the /posts POST endpoint within post-service
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(Post post);

    // Invoke .getPost(id) in THIS service's controller
    // to invoke the /posts/{id} GET endpoint within post-service
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id);

    // Invoke .findPostsByPoster(posterName) in THIS service's controller
    // to invoke the /posts/user/{posterName} GET endpoint within post-service;
    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    public List<Post> getPostsByPoster(@PathVariable String posterName);

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts();

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id);
}
