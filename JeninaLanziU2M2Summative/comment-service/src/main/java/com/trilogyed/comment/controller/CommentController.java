package com.trilogyed.comment.controller;

import com.trilogyed.comment.CommentServiceApplication;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class CommentController {

    @Autowired
    CommentDao commentDao;

    // POST METHOD
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment) {

        // ***** CHANGE THIS!!!!Comment creation - DO THIS AT THE MESSAGE LISTENER LEVEL
        commentDao.addComment(comment);
        return commentDao.getComment(comment.getCommentId());
    }

    // GET ALL METHOD
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    // GET BY POST METHOD
    @RequestMapping(value = "/comments/post/{postId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getCommentsByPost(@PathVariable int postId) {
        return commentDao.getCommentsByPost(postId);
    }

    // GET BY ID METHOD
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Comment getComment(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Comment ID cannot be zero!");
        }
        return commentDao.getComment(id);
    }

    // UPDATE METHOD
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void updateComment(@PathVariable int id, @RequestBody @Valid Comment comment) {
        for (Comment c : commentDao.getAllComments()) {
            if (c.getCommentId() == id) {
                comment.setCommentId(id);
                commentDao.updateComment(comment);
            }
        }
        System.out.println("Comment successfully updated!");
    }

    // DELETE METHOD
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteComment(@PathVariable int id) {
        commentDao.deleteComment(id);
        System.out.println("Comment successfully deleted.");
    }

}
