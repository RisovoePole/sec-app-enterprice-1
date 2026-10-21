package org.example.good;

import org.springframework.stereotype.Component;

@Component
public class PushTicketSender implements TicketSender {

    public void send(User user, String message) {
        System.out.println("PUSH -> " + message);
    }
}
