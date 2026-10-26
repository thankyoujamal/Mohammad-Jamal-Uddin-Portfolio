package com.mjamal.portfolio.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
        @NotBlank(message = "Fill in your name so I can reply.")
        @Size(max = 100, message = "Keep your name under 100 characters.")
        String name,

        @NotBlank(message = "Fill in your email so I can reply.")
        @Email(message = "That email address looks incomplete. Check it and try again.")
        @Size(max = 150, message = "Keep your email under 150 characters.")
        String email,

        @NotBlank(message = "Write a short message before sending.")
        @Size(max = 2000, message = "Keep your message under 2000 characters.")
        String message) {
}
