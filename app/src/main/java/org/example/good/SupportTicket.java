package org.example.good;

import org.example.good.User;

public record SupportTicket(User user, double priorityValue, String status) {}
