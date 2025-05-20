package com.example.grind.model;

import java.util.List;

public class VotingQuestion {
    private final String question;
    private final List<String> options;

    public VotingQuestion(String question, List<String> options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }
}
