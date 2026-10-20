package org.example.good;

public class SmsTicketSender implements TicketSender {

    public void send(User user, String message) {
        System.out.println("SMS -> " + user.phone() + ": " + message);
    }
}
