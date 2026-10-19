package org.example.bad;

public class SmsTicketSender {

    public void send(String phone, String message) {
        System.out.println("SMS -> " + phone + ": " + message);
    }
}
