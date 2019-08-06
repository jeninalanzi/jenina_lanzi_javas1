package com.company.JeninaLanziU1M5Summative.dao;

import com.company.JeninaLanziU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {

    /*
    author_id int not null auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null
     */

    Author addAuthor(Author author);

    Author getAuthor(int authorId);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(int authorId);

}
