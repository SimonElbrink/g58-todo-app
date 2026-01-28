package se.lexicon.g58todoapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g58todoapp.entity.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    List<Todo> findByTitleContainingIgnoreCase(String title);
    List<Todo> findByAssignedTo_Id(Long personId);
    List<Todo> findByCompleted(boolean completed);
    List<Todo> findByDueDateBetween(LocalDateTime start, LocalDateTime end);
    List<Todo> findByDueDateBeforeAndCompletedFalse(LocalDateTime dateTime);
    List<Todo> findByAssignedToIsNull();
    List<Todo> findByCompletedFalseAndDueDateBefore(LocalDateTime dateTime);
    List<Todo> findByAssignedTo_IdAndCompletedTrue(Long personId);
    List<Todo> findByDueDateIsNull();
    long countByAssignedTo_Id(Long personId);
    
}