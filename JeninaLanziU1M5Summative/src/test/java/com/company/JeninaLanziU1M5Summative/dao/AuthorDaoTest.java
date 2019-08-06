package com.company.JeninaLanziU1M5Summative.dao;

import com.company.JeninaLanziU1M5Summative.model.Author;
import com.company.JeninaLanziU1M5Summative.model.Book;
import com.company.JeninaLanziU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        List<Book> bList = bookDao.getAllBooks();
        for (Book b : bList) {
            bookDao.deleteBook(b.getBookId());
        }

        List<Author> aList = authorDao.getAllAuthors();
        for (Author a : aList) {
            authorDao.deleteAuthor(a.getAuthorId());
        }

        List<Publisher> pList = publisherDao.getAllPublishers();

        for (Publisher p : pList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }

    }

    @Test
    public void addGetDeleteAuthor() {

        // Create an author object
        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName(("Tolkien"));
        author.setStreet("111 Test Street");
        author.setCity("Oxford");
        author.setState("UK");
        author.setPostalCode("00000");
        author.setPhone("111-111-1111");
        author.setEmail("tolkien@middleearth.com");

        authorDao.addAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author1, author);

        authorDao.deleteAuthor(author.getAuthorId());

        author1 = authorDao.getAuthor(author.getAuthorId());

        assertNull(author1);
    }

    @Test
    public void updateAuthor() {

        // Create an author object
        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName(("Tolkien"));
        author.setStreet("111 Test Street");
        author.setCity("Oxford");
        author.setState("UK");
        author.setPostalCode("00000");
        author.setPhone("111-111-1111");
        author.setEmail("tolkien@middleearth.com");

        authorDao.addAuthor(author);

        // Update the pre-existing object
        author.setStreet("345 Hobbiton Lane");
        author.setPostalCode("21345");

        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author1, author);
    }

    @Test
    public void getAllAuthors() {

        // Create an author object
        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName(("Tolkien"));
        author.setStreet("111 Test Street");
        author.setCity("Oxford");
        author.setState("UK");
        author.setPostalCode("00000");
        author.setPhone("111-111-1111");
        author.setEmail("tolkien@middleearth.com");

        // Create another author
        Author author1 = new Author();
        author1.setFirstName("Ernest");
        author1.setLastName(("Hemingway"));
        author1.setStreet("908 Sample Blvd.");
        author1.setCity("Oak Park");
        author1.setState("IL");
        author1.setPostalCode("60111");
        author1.setPhone("773-222-5555");
        author1.setEmail("ehemingway@email.com");

        // Add into dao
        authorDao.addAuthor(author);
        authorDao.addAuthor(author1);

        List<Author> authorList = authorDao.getAllAuthors();

        assertEquals(authorList.size(), 2);
    }
}
