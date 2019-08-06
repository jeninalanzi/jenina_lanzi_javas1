package com.company.JeninaLanziU1M5Summative.dao;

import com.company.JeninaLanziU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {
    /*
    publisher_id int not null auto_increment primary key,
    name varchar(50)not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null
     */

    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int publisherId);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int publisherId);
}
