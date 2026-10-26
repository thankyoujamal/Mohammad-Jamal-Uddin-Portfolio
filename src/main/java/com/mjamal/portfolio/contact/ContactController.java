package com.mjamal.portfolio.contact;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactMessageRepository repository;

    public ContactController(ContactMessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> submit(@Valid @RequestBody ContactRequest request) {
        repository.save(new ContactMessage(request.name().trim(), request.email().trim(), request.message().trim()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Thanks, " + request.name().trim() + ". Your message was sent."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> invalid(MethodArgumentNotValidException ex) {
        var error = ex.getBindingResult().getFieldErrors().getFirst();
        return ResponseEntity.badRequest()
                .body(Map.of("field", error.getField(), "message", error.getDefaultMessage()));
    }
}
