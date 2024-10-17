package TaskRepository.java;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository<Task> extends JpaRepository<Task, Long> {
    List<Task> findByIsCompleted(boolean isCompleted);
}
