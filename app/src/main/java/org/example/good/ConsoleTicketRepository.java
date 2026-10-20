package org.example.good;

import org.springframework.stereotype.Repository;

@Repository
public class ConsoleTicketRepository implements TicketRepository {

    public void save(SupportTicket value) {
        System.out.println("SAVED -> " + value);
    }
}
