package com.example.magic8ballapi.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Answer {

    @NotEmpty(message = "You must supply a question!")
    @Size(min = 4, max = 100, message = "Question must be at least 4 characters in length")
    private String question;

    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
