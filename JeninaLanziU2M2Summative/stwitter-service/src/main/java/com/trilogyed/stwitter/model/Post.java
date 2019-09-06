package com.trilogyed.stwitter.model;

// This POJO is strictly for translating data from post-service
// This is an identical object.

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private int postID;

    @NotEmpty(message = "You must supply a value for post date!")
    private LocalDate postDate;

    @NotEmpty(message = "You must supply a value for poster name!")
    @Size(max = 50, message = "Name cannot exceed 50 chars.")
    private String posterName;

    @NotEmpty(message = "You must supply a value for post!")
    @Size(max = 255, message = "Max size of post is 255 chars long.")
    private String post;

    // Getters, setters, hashCode, toString, equals.
    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return getPostID() == post1.getPostID() &&
                getPostDate().equals(post1.getPostDate()) &&
                getPosterName().equals(post1.getPosterName()) &&
                getPost().equals(post1.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostID(), getPostDate(), getPosterName(), getPost());
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                '}';
    }

}
