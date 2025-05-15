package com.example.grind;

import com.example.grind.model.Voting;

import java.util.List;

public class VoteRoomSession {
    private static VoteRoomSession instance;
    private int roomCode;
    private String roomTitle;
    private List<String> users;
    private List<Voting> votings;

    private VoteRoomSession() {
    }

    public static VoteRoomSession getInstance() {
        if (instance == null) {
            instance = new VoteRoomSession();
        }
        return instance;
    }

    public void setRoom(int code, String title) {
        this.roomCode = code;
        this.roomTitle = title;
    }

    public void addUser(String user) {
        users.add(user);
    }

    public void addVoting(Voting voting) {
        votings.add(voting);
    }

    public List<String> getUsers() {
        return users;
    }

    public List<Voting> getVotings() {
        return votings;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public String getRoomTitle() {
        return roomTitle;
    }
}
