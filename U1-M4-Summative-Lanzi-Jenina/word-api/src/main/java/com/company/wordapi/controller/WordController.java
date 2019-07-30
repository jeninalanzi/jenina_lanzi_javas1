package com.company.wordapi.controller;

import com.company.wordapi.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
public class WordController {

    // Initializing in-memory storage for the motorcycle inventory.
    List<Word> wordList = new ArrayList<>();

    // GET Method
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word getDefinition() {
        // Random for accessing random index between 0-9.
        Random random = new Random();
        int randomWord = random.nextInt(9);

        // Populate the DAO with 10 word/definition sets.

        Word word1 = new Word();
        word1.setWord("inflexible");
        word1.setDefinition("of a rigid or unyielding temper, purpose, will, etc.; immovable.");

        Word word2 = new Word();
        word2.setWord("addlepated");
        word2.setDefinition("being mixed up; confused.");

        Word word3 = new Word();
        word3.setWord("grenadine");
        word3.setDefinition("thin syrup made from pomegranate juice; used in mixed drinks.");

        Word word4 = new Word();
        word4.setWord("bromide");
        word4.setDefinition("a trite or obvious remark.");

        Word word5 = new Word();
        word5.setWord("sacrilege");
        word5.setDefinition("blasphemous behavior; the act of depriving something of its sacred character.");

        Word word6 = new Word();
        word6.setWord("fjord");
        word6.setDefinition("a long narrow inlet of the sea between steep cliffs; common in Norway.");

        Word word7 = new Word();
        word7.setWord("trivium");
        word7.setDefinition("(Middle Ages) an introductory curriculum at a medieval university involving grammar and logic and rhetoric; considered to be a triple way to eloquence.");

        Word word8 = new Word();
        word8.setWord("loquacious");
        word8.setDefinition("full of trivial conversation.");

        Word word9 = new Word();
        word9.setWord("gregarious");
        word9.setDefinition("instinctively or temperamentally seeking and enjoying the company of others.");

        Word word10 = new Word();
        word10.setWord("scarlet");
        word10.setDefinition("a variable color that is vivid red but sometimes with an orange tinge.");

        wordList.add(word1);
        wordList.add(word2);
        wordList.add(word3);
        wordList.add(word4);
        wordList.add(word5);
        wordList.add(word6);
        wordList.add(word7);
        wordList.add(word8);
        wordList.add(word9);
        wordList.add(word10);

        return wordList.get(randomWord);
    }
}
