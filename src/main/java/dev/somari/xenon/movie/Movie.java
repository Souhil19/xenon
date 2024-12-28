package dev.somari.xenon.movie;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Movie(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer room

) {
    public Movie {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("StartedOn must be before CompletedOn");
        }
        if (room < 0) {
            throw new IllegalArgumentException("Room must be positive");
        }
    }
}
