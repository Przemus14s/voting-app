package com.example.grind;

import com.example.grind.model.VotingQuestion;

import java.util.ArrayList;
import java.util.List;

public class VoteRoomSession {
    private static final VoteRoomSession instance = new VoteRoomSession();

    private int roomCode;
    private String roomTitle;
    private final List<VotingQuestion> votingQuestions = new ArrayList<>();

    // ✅ Dodane pole do przechowywania użytkowników
    private final List<String> users;

    private VoteRoomSession() {
        users = new ArrayList<>();
    }

    public static VoteRoomSession getInstance() {
        return instance;
    }

    public void setRoom(int code, String title) {
        this.roomCode = code;
        this.roomTitle = title;
        votingQuestions.clear(); // Wyczyszczenie pytań przy tworzeniu nowego pokoju
        users.clear(); // Wyczyszczenie użytkowników przy tworzeniu nowego pokoju
    }

    public int getRoomCode() {
        return roomCode;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void addQuestion(VotingQuestion question) {
        votingQuestions.add(question);
    }

    public List<VotingQuestion> getQuestions() {
        return votingQuestions;
    }

    // ✅ Nowe metody do zarządzania użytkownikami
    public void addUser(String username) {
        if (username != null && !username.trim().isEmpty()) {
            users.add(username.trim());
        }
    }

    public List<String> getUsers() {
        return users;
    }

    public void clearUsers() {
        users.clear();
    }
}
