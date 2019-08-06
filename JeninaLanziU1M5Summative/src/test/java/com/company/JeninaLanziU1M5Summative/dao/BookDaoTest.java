package com.company.JeninaLanziU1M5Summative.dao;

import com.company.JeninaLanziU1M5Summative.model.Author;
import com.company.JeninaLanziU1M5Summative.model.Book;
import com.company.JeninaLanziU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

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
    public void addGetDeleteBook() {

        // Create an author and publisher first
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setStreet("345 Corgi Lane");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("02341");
        publisher.setPhone("111-3333");
        publisher.setEmail("info@penguinbooks.com");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName(("Tolkien"));
        author.setStreet("111 Test Street");
        author.setCity("Oxford");
        author.setState("UK");
        author.setPostalCode("00000");
        author.setPhone("111-111-1111");
        author.setEmail("tolkien@middleearth.com");
        author = authorDao.addAuthor(author);

        // Create the book next
        Book book = new Book();
        book.setIsbn("34534546356");
        book.setPublishDate(LocalDate.of(1959, 05, 05));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Lord Of The Rings");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("28.95"));

        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getBookId());

        assertEquals(book1, book);

        bookDao.deleteBook(book.getBookId());

        book1 = bookDao.getBook(book.getBookId());

        assertNull(book1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {
        Book book = new Book();
        book.setIsbn("34534546356");
        book.setPublishDate(LocalDate.of(1959, 05, 05));
        book.setAuthorId(12);
        book.setTitle("Lord Of The Rings");
        book.setPublisherId(13);
        book.setPrice(new BigDecimal("28.95"));

        book = bookDao.addBook(book);
    }

    @Test
    public void getAllBooks() {

        // Create an author and publisher first
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setStreet("345 Corgi Lane");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("02341");
        publisher.setPhone("111-3333");
        publisher.setEmail("info@penguinbooks.com");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName(("Tolkien"));
        author.setStreet("111 Test Street");
        author.setCity("Oxford");
        author.setState("UK");
        author.setPostalCode("00000");
        author.setPhone("111-111-1111");
        author.setEmail("tolkien@middleearth.com");
        author = authorDao.addAuthor(author);

        // Create the book(s) next
        Book book = new Book();
        book.setIsbn("34534546356");
        book.setPublishDate(LocalDate.of(1959, 05, 05));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Lord Of The Rings");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("28.95"));

        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("675754564");
        book.setPublishDate(LocalDate.of(1979, 07, 05));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Silmarillion");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("30.95"));

        book = bookDao.addBook(book);

        List<Book> bookList = bookDao.getAllBooks();

        assertEquals(bookList.size(), 2);

    }

    @Test
    public void updateBook() {
        // Create an author and publisher first
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setStreet("345 Corgi Lane");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("02341");
        publisher.setPhone("111-3333");
        publisher.setEmail("info@penguinbooks.com");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName(("Tolkien"));
        author.setStreet("111 Test Street");
        author.setCity("Oxford");
        author.setState("UK");
        author.setPostalCode("00000");
        author.setPhone("111-111-1111");
        author.setEmail("tolkien@middleearth.com");
        author = authorDao.addAuthor(author);

        // Create the book(s) next
        Book book = new Book();
        book.setIsbn("34534546356");
        book.setPublishDate(LocalDate.of(1959, 05, 05));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Lord Of The Rings");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("28.95"));

        book = bookDao.addBook(book);

        book.setTitle("The Silmarillion");

        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getBookId());
        assertEquals(book1, book);
    }

    @Test
    public void getBookByAuthor() {
        // Create an author and publisher first
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setStreet("345 Corgi Lane");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("02341");
        publisher.setPhone("111-3333");
        publisher.setEmail("info@penguinbooks.com");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName(("Tolkien"));
        author.setStreet("111 Test Street");
        author.setCity("Oxford");
        author.setState("UK");
        author.setPostalCode("00000");
        author.setPhone("111-111-1111");
        author.setEmail("tolkien@middleearth.com");
        author = authorDao.addAuthor(author);

        // Create the book(s) next
        Book book = new Book();
        book.setIsbn("34534546356");
        book.setPublishDate(LocalDate.of(1959, 05, 05));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Lord Of The Rings");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("28.95"));

        book = bookDao.addBook(book);

        List<Book> booksByTolkien = bookDao.getBooksByAuthor(book.getAuthorId());

        assertEquals(booksByTolkien.size(), 1);
    }
}
