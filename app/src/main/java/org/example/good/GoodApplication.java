package org.example.good;

public class GoodApplication {

    public static void main(String[] args) {
        TicketRepository repo = new ConsoleTicketRepository();
        UserValidator validator = new UserValidator();
        SupportService service = new SupportService(repo, validator);
        User user = new User(
            106L,
            "victor",
            "student@example.com",
            "+37360000000"
        );
        TicketSender ticketSender = new EmailTicketSender();
        SupportTicket result = service.openTicket(user, 5, ticketSender);
        System.out.println("RESULT -> " + result);
    }
}
