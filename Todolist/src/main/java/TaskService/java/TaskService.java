package TaskService.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Task.java.Task;
import TaskRepository.java.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository<Task> taskRepository;
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Task createTask(Task task) {
        return (Task) taskRepository.save(task);
    }
    
    public Task updateTask(Task task) {
        return (Task) taskRepository.save(task);
    }
    
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

	public Task getTask(Long id) {
	
		return null;
	}
}