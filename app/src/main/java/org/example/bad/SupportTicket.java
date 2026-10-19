package org.example.bad;

public record SupportTicket(
    long id,
    String email,
    String phone,
    double priorityValue,
    String status
) {}
