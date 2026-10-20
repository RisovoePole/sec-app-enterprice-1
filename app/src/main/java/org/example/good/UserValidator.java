package org.example.good;

public class UserValidator {

    public void ValidateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
    }

    public void ValidatePriority(double priorityValue) {
        if (priorityValue <= 0) throw new IllegalArgumentException(
            "priorityValue must be positive"
        );
    }
}
