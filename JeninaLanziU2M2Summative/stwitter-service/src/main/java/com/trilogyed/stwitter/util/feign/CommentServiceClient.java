package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// This now has full access to all endpoints in comment-service.

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    // Invoke .getCommentsByPost(postId) in THIS service's controller
    // to invoke the /comments/post/{postId} GET endpoint within comment-service
    @RequestMapping(value = "/comments/post/{postId}", method = RequestMethod.GET)
    public List<Comment> getCommentsByPost(@PathVariable int postId);

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody @Valid Comment comment);

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<Comment> getAllComments();

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable int id);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    public void updateComment(@PathVariable int id, @RequestBody @Valid Comment comment);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int id);

}
