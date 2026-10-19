package org.example.bad;

import org.example.bad.ConsoleTicketRepository;

public class SupportService {

    public SupportTicket openTicket(
        long id,
        String email,
        String phone,
        double priorityValue,
        String channel
    ) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (priorityValue <= 0) throw new IllegalArgumentException(
            "priorityValue must be positive"
        );

        String status = priorityValue >= 4 ? "SPECIAL" : "STANDARD";
        SupportTicket value = new SupportTicket(
            id,
            email,
            phone,
            priorityValue,
            status
        );

        ConsoleTicketRepository repository = new ConsoleTicketRepository();
        repository.save(value);

        String message = "TICKET " + id + " completed. Status: " + status;
        if ("EMAIL".equalsIgnoreCase(channel)) {
            new EmailTicketSender().send(email, message);
        } else if ("SMS".equalsIgnoreCase(channel)) {
            new SmsTicketSender().send(phone, message);
        } else {
            throw new IllegalArgumentException("Unknown channel: " + channel);
        }

        return value;
    }
}
