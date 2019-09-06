package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.util.messages.CommentEntry;
import com.trilogyed.stwitter.view.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class StwitterController {

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.add.comment.controller";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private final PostServiceClient postClient;

    @Autowired
    private final CommentServiceClient commentClient;

    @Autowired
    ServiceLayer service;

    public StwitterController(RabbitTemplate rabbitTemplate, PostServiceClient postClient, CommentServiceClient commentClient, ServiceLayer service) {
        this.rabbitTemplate = rabbitTemplate;
        this.postClient = postClient;
        this.commentClient = commentClient;
        this.service = service;
    }

    // WHEN THE END USER HITS THESE ENDPOINTS,
    // IT USES THE FEIGN CLIENT TO ACCESS THE POST DAO.
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public PostViewModel createPost(@RequestBody @Valid PostViewModel viewModel) {
        service.savePost(viewModel);

        return service.findPost(viewModel.getPostId());
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public PostViewModel getPost(@PathVariable int id) {
        return service.findPost(id);
    }

    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    public List<PostViewModel> getAllPostsByPoster(@PathVariable String posterName) { return service.findPostsByPoster(posterName); }

    // ENDPOINT so users can add comments to an existing Post through Stwitter.
    // This is where the comment/message will be PRODUCED and sent to the queue.
    // Comment won't actually be added until we reach the Consumer level.
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody @Valid Comment comment) {

        CommentEntry msg = new CommentEntry(comment.getPostId(), comment.getCreateDate(), comment.getCommenterName(), comment.getComment());
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        System.out.println("Message Sent");

        System.out.println("Account Created");

        // Post comment to DAO through the service layer.
//        return service.addCommentToPost(comment);
        return comment;

    }
}
