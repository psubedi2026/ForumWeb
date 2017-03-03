package com.novauc;

/**
 * Created by psubedi2020 on 3/2/17.
 */
public class Message {
    int id;
    int replyId;
    String author;
    String text;

    public Message(int id, int replyId, String author, String text) {
        this.id = id;
        this.replyId = replyId;
        this.author = author;
        this.text = text;
    }
}


