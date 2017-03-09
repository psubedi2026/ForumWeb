package com.novauc;

/**
 * Created by psubedi2020 on 3/2/17.
 */
public class User {
    int id;
    String name;
    String password;

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

