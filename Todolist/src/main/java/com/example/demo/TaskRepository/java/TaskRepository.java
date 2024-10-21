package com.example.demo.TaskRepository.java;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Task.java.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // custom query methods (if needed)
}