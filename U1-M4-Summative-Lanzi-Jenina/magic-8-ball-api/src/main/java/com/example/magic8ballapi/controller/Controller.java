package com.example.magic8ballapi.controller;

import com.example.magic8ballapi.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
public class Controller {

    List<String> magic8AnswerList = new ArrayList<>();
    List<Answer> answerList = new ArrayList<>();

    // POST method
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer askQuestion(@RequestBody @Valid Answer answer) {

        Random random = new Random();
        int randomInt = random.nextInt(11);

        // Populate the magic8AnswerList with 6 different possible answers.
        magic8AnswerList.add("Yes");
        magic8AnswerList.add("Of course not!");
        magic8AnswerList.add("I think you should think twice about that.");
        magic8AnswerList.add("This is auspicious for you.");
        magic8AnswerList.add("This will totally work out!");
        magic8AnswerList.add("Nah. Don't do it.");
        magic8AnswerList.add("Can you see yourself doing this long-term? If not, move on.");
        magic8AnswerList.add("Look to your right :)");
        magic8AnswerList.add("I can tell that's not a good idea.");
        magic8AnswerList.add("You've felt for a long time that this is right for you.");
        magic8AnswerList.add("Try cleaning your room.");
        magic8AnswerList.add("The universe is definitely in your favor here.");

        // Post the question
        answerList.add(answer);

        // Generate random answer for the question posed.
        answer.setAnswer(magic8AnswerList.get(randomInt));

        return answer;

    }




}
