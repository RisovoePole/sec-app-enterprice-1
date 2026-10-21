package org.example.good;

import org.example.good.ConsoleTicketRepository;
import org.springframework.stereotype.Service;

@Service
public class SupportService {

    public TicketRepository repository;
    public UserValidator userValidator;

    public SupportService(
        TicketRepository ticketRepository,
        UserValidator userValidator
    ) {
        this.repository = ticketRepository;
        this.userValidator = userValidator;
    }

    public SupportTicket openTicket(
        User user,
        double priorityValue,
        TicketSender ticketSender
    ) {
        userValidator.ValidateEmail(user.email());
        userValidator.ValidatePriority(priorityValue);
        String status = priorityValue >= 4 ? "SPECIAL" : "STANDARD";
        SupportTicket value = new SupportTicket(user, priorityValue, status);

        repository.save(value);

        String message =
            "TICKET " + user.id() + " completed. Status: " + status;

        ticketSender.send(user, message);
        return value;
    }
}
