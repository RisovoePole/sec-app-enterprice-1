package org.example.good;

public class EmailTicketSender implements TicketSender {

    public void send(User user, String message) {
        System.out.println("EMAIL -> " + user.email() + ": " + message);
    }
}
