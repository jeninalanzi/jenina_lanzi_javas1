package com.trilogyed.comment.util.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.trilogyed.comment.model.Comment;

import java.time.LocalDate;


// This is the message to be passed on between producer and consumer.
// Will not have a comment ID.
public class CommentEntry {

    private int postId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public CommentEntry() {}

    public CommentEntry(int postId, LocalDate createDate, String commenterName, String comment) {
       this.postId = postId;
       this.createDate = createDate;
       this.commenterName = commenterName;
       this.comment = comment;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentEntry{" +
                "postId=" + postId +
                ", createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
