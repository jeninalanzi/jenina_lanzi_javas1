package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        List<Comment> cList = commentDao.getAllComments();
        for (Comment c : cList) {
            commentDao.deleteComment(c.getCommentId());
        }
    }

    @Test
    public void getAddDeleteComment() {

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 3));
        comment.setCommenterName("Benjamin");
        comment.setComment("Hello World!");

        comment = commentDao.addComment(comment);

        Comment testComment = commentDao.getComment(comment.getCommentId());

        assertEquals(testComment, comment);

        commentDao.deleteComment(comment.getCommentId());

        testComment = commentDao.getComment(comment.getCommentId());

        assertNull(testComment);
    }

    @Test
    public void updateComment() {

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 3));
        comment.setCommenterName("Benjamin");
        comment.setComment("Hello World!");

        comment = commentDao.addComment(comment);

        comment.setCommenterName("Ben");
        comment.setComment("Hello again!");

        commentDao.updateComment(comment);

        Comment testComment = commentDao.getComment(comment.getCommentId());

        assertEquals(testComment, comment);

    }

    @Test
    public void getAllComments() {

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 2));
        comment.setCommenterName("Benjamin");
        comment.setComment("Hello World!");

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 9, 3));
        comment2.setCommenterName("George");
        comment2.setComment("I agree with Ben!");

        comment = commentDao.addComment(comment);
        comment2 = commentDao.addComment(comment2);

        List<Comment> allComments = commentDao.getAllComments();

        assertEquals(2, allComments.size());
    }
}
