package com.example.grind.model;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private static Session instance;
    private List<String> users;

    private Session() {
        users = new ArrayList<>();
    }

    // Singleton - globalny dostęp do jednej instancji
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

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

