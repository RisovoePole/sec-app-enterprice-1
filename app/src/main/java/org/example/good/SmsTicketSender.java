package org.example.good;

import org.springframework.stereotype.Component;

@Component
public class SmsTicketSender implements TicketSender {

    public void send(User user, String message) {
        System.out.println("SMS -> " + user.phone() + ": " + message);
    }
}
