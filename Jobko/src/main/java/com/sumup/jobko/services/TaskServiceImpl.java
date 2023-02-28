package com.sumup.jobko.services;

import com.sumup.jobko.models.Task;
import com.sumup.jobko.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> process() {
        return taskRepository.process();
    }

    @Override
    public void create(Task task) {
        taskRepository.create(task);
    }

    @Override
    public void update(Task task) {
        taskRepository.update(task);
    }

    @Override
    public void delete(int id) {
        taskRepository.delete(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public Task getById(int id) {
        return taskRepository.getById(id);
    }

    @Override
    public Task getByName(String name) {
        return taskRepository.getByName(name);
    }
}