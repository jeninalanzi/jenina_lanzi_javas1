package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
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
public class PostDaoJdbcTemplateImplTest {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Post> pList = postDao.getAllPosts();
        for (Post p : pList) {
            postDao.deletePost(p.getPostID());
        }
    }

    @Test
    public void addGetDeletePost() {

        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 4, 6));
        post.setPosterName("Jean Johnson");
        post.setPost("This is a test post to see the output of the tests.");

        post = postDao.addPost(post);

        Post postTest = postDao.getPost(post.getPostID());

        assertEquals(postTest, post);

        postDao.deletePost(post.getPostID());

        postTest = postDao.getPost(post.getPostID());

        assertNull(postTest);
    }

    @Test
    public void updatePost() {

        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 4, 6));
        post.setPosterName("Jean Johnson");
        post.setPost("This is a test post to see the output of the tests.");

        post = postDao.addPost(post);

        post.setPostDate(LocalDate.of(2019, 9, 3));
        post.setPost("I decided to change my content.");

        postDao.updatePost(post);

        Post postTest = postDao.getPost(post.getPostID());

        assertEquals(postTest, post);
    }

    @Test
    public void getAllPosts() {

        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 4, 6));
        post.setPosterName("Jean Johnson");
        post.setPost("This is a test post to see the output of the tests.");

        Post post2 = new Post();
        post2.setPostDate(LocalDate.of(2019, 9, 3));
        post2.setPosterName("Heather Johnson");
        post2.setPost("I'm posting something just because my sister did.");

        post = postDao.addPost(post);
        post2 = postDao.addPost(post2);

        List<Post> allPosts = postDao.getAllPosts();

        assertEquals(2, allPosts.size());

    }

}
