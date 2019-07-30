package com.company.quoteapi.controller;

import com.company.quoteapi.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
public class QuoteController {

    // In-memory DAO
    List<Quote> quotesList = new ArrayList<>();


    // GET method
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {

        // Random to access random index (using 0-9 due to index constraints).
        Random random = new Random();
        int randomQuote = random.nextInt(9);

        // Populate the DAO with 10 quotes.
        Quote quote1 = new Quote();
        quote1.setQuote("The highest education is that which does not merely give us information but makes our life in harmony with all existence.");
        quote1.setAuthor("Rabindranath Tagore");

        Quote quote2 = new Quote();
        quote2.setQuote("On the mountains of truth you can never climb in vain: either you will reach a point higher up today, or you will be training your powers so that you will be able to climb higher tomorrow.");
        quote2.setAuthor("Friedrich Nietzsche");

        Quote quote3 = new Quote();
        quote3.setQuote("The most wasted of all days is one without laughter.");
        quote3.setAuthor("Nicholas Chamfort");

        Quote quote4 = new Quote();
        quote4.setQuote("The possession of knowledge does not kill the sense of wonder and mystery. There is always more mystery.");
        quote4.setAuthor("Anais Nin");

        Quote quote5 = new Quote();
        quote5.setQuote("Whenever you find yourself on the side of the majority, it is time to reform (or pause and reflect).");
        quote5.setAuthor("Mark Twain");

        Quote quote6 = new Quote();
        quote6.setQuote("The simple things are also the most extraordinary things, and only the wise can see them.");
        quote6.setAuthor("Paul Coelho");

        Quote quote7 = new Quote();
        quote7.setQuote("A wise man will make more opportunities than he finds.");
        quote7.setAuthor("Francis Bacon");

        Quote quote8 = new Quote();
        quote8.setQuote("Rome seems a comfort to those with the ambitious soul of an Artist or a Conqueror.");
        quote8.setAuthor("Pietros Maneos");

        Quote quote9 = new Quote();
        quote9.setQuote("Go to heaven for the climate and hell for the company.");
        quote9.setAuthor("Benjamin Franklin Wade");

        Quote quote10 = new Quote();
        quote10.setQuote("...when dogma enters the brain, all intellectual activity ceases.");
        quote10.setAuthor("Robert Anton Wilson");

        quotesList.add(quote1);
        quotesList.add(quote2);
        quotesList.add(quote3);
        quotesList.add(quote4);
        quotesList.add(quote5);
        quotesList.add(quote6);
        quotesList.add(quote7);
        quotesList.add(quote8);
        quotesList.add(quote9);
        quotesList.add(quote10);

//        System.out.println(quotesList);

        return quotesList.get(randomQuote);
    }


}
