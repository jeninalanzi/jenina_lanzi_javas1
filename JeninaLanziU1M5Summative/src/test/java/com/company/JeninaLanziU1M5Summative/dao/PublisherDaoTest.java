package com.company.JeninaLanziU1M5Summative.dao;

import com.company.JeninaLanziU1M5Summative.model.Author;
import com.company.JeninaLanziU1M5Summative.model.Book;
import com.company.JeninaLanziU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoTest {

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
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setStreet("345 Corgi Lane");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("02341");
        publisher.setPhone("111-3333");
        publisher.setEmail("info@penguinbooks.com");

        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getPublisherId());

        publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertNull(publisher1);

    }

    @Test
    public void getAllPublishers() {

        // Create 2 publisher objects
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setStreet("345 Corgi Lane");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("02341");
        publisher.setPhone("111-3333");
        publisher.setEmail("info@penguinbooks.com");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Viking Press");
        publisher2.setStreet("200 Los Angeles Blvd");
        publisher2.setCity("Los Angeles");
        publisher2.setState("CA");
        publisher2.setPostalCode("93456");
        publisher2.setPhone("444-2222");
        publisher2.setEmail("info@vikingpressprinting.com");

        publisherDao.addPublisher(publisher);
        publisherDao.addPublisher(publisher2);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), 2);
    }

    @Test
    public void updatePublisher() {

        // Create a new publisher
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setStreet("345 Corgi Lane");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("02341");
        publisher.setPhone("111-3333");
        publisher.setEmail("info@penguinbooks.com");

        publisherDao.addPublisher(publisher);

        publisher.setStreet("1111 Penguin Lane");
        publisher.setPhone("444-5555");

        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());
        assertEquals(publisher1, publisher);
    }
}
