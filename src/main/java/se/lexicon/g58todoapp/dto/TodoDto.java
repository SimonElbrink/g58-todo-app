package se.lexicon.g58todoapp.dto;

import java.time.LocalDateTime;

public record TodoDto(
        Long id,
        String title,
        String description,
        LocalDateTime dueDate,
        boolean completed,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long assignedToId,
        int numberOfAttachments
) {
}
