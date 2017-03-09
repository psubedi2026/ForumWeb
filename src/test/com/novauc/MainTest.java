package com.novauc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by psubedi2020 on 3/8/17.
 */
public class MainTest {

    public Connection startConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Main.createTables(conn);
        return conn;
    }

    @Test
    public void testUser() throws SQLException {
        Connection conn = startConnection();
        Main.insertUser(conn, "Alice", "");
        User user = Main.selectUser(conn, "Alice");
        conn.close();
        assertTrue(user != null);
    }

    @Test
    public void testMessage() throws SQLException {
        Connection conn = startConnection();
        Main.insertUser(conn, "Alice", "");
        User user = Main.selectUser(conn, "Alice");
        Main.insertMessage(conn, user.id, -1, "Hello, world!");
        Message message = Main.selectMessage(conn, 1);
        conn.close();
        assertTrue(message != null);
    }




        @Test
        public void testReplies() throws SQLException {
            Connection conn = startConnection();
            Main.insertUser(conn, "Alice", "");
            Main.insertUser(conn, "Bob", "");
            User alice = Main.selectUser(conn, "Alice");
            User bob = Main.selectUser(conn, "Bob");
            Main.insertMessage(conn, alice.id, -1, "Hello, world!");
            Main.insertMessage(conn, bob.id, 1, "This is a reply!");
            Main.insertMessage(conn, bob.id, 1, "This is another reply!");
            ArrayList<Message> replies = Main.selectReplies(conn, 1);
            conn.close();
            assertTrue(replies.size() == 2);
        }

 }

