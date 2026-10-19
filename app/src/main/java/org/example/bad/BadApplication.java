package org.example.bad;

public class BadApplication {

    public static void main(String[] args) {
        SupportService service = new SupportService();
        SupportTicket result = service.openTicket(
            106L,
            "student@example.com",
            "+37360000000",
            5,
            "EMAIL"
        );
        System.out.println("RESULT -> " + result);
    }
}
