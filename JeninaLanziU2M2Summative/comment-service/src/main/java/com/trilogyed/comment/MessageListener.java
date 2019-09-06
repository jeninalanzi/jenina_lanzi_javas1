package com.trilogyed.comment;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.util.messages.CommentEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentDao commentDao;

    // This annotation specifies the queues that this component will listen to.
    @RabbitListener(queues = CommentServiceApplication.QUEUE_NAME)
    public void receiveMessage(CommentEntry msg) {
        System.out.println(msg.toString());

        // In a real app, you would use "msg" to create
        // a new comment entry.
        Comment newComment = new Comment();
        newComment.setPostId(msg.getPostId());
        newComment.setCreateDate(msg.getCreateDate());
        newComment.setCommenterName(msg.getCommenterName());
        newComment.setComment(msg.getComment());

        newComment = commentDao.addComment(newComment);
        newComment.setCommentId(newComment.getCommentId());

        System.out.println("Message received and processed.");
    }
}
