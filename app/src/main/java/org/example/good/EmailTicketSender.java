package org.example.good;

import org.springframework.stereotype.Component;

@Component
public class EmailTicketSender implements TicketSender {

    public void send(User user, String message) {
        System.out.println("EMAIL -> " + user.email() + ": " + message);
    }
}
