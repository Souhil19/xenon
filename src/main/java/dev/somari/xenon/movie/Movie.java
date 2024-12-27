package dev.somari.xenon.movie;

import java.time.LocalDateTime;

public record Movie(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer room

) {
}
