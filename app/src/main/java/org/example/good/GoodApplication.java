package org.example.good;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GoodApplication {

    public static void main(String[] args) {
        try (
            var context = new AnnotationConfigApplicationContext(
                ApplicationConfig.class
            )
        ) {
            SupportService service = context.getBean(SupportService.class);
            User user = new User(
                106L,
                "victor",
                "student@example.com",
                "+37360000000"
            );
            User wrongUser = new User(106L, "victor", "", "+37360000000");
            try {
                SupportTicket ticket1 = service.openTicket(
                    wrongUser,
                    5,
                    context.getBean(EmailTicketSender.class)
                );
                System.out.println("RESULT -> " + ticket1 + "\n");
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage() + "\n");
            }
            SupportTicket ticket2 = service.openTicket(
                user,
                5,
                context.getBean(SmsTicketSender.class)
            );
            System.out.println("RESULT -> " + ticket2 + "\n");
            SupportTicket ticket3 = service.openTicket(
                user,
                200,
                context.getBean(PushTicketSender.class)
            );
            System.out.println("RESULT -> " + ticket3 + "\n");
        }
    }
}
