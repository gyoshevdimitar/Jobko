package com.sumup.jobko.utilities;

import com.sumup.jobko.models.Task;
import com.sumup.jobko.models.TaskDto;
import com.sumup.jobko.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ModelMapper {
    private final TaskRepository taskRepository;

    @Autowired
    public ModelMapper(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task fromDto(TaskDto taskDto) {
        Task task = new Task();
        dtoToObject(taskDto, task);
        return task;
    }

    public Task fromDto(TaskDto taskDto, int id) {
        Task task = taskRepository.getById(id);
        dtoToObject(taskDto, task);
        if (taskDto.getRequires() != null) {
            Set<Task> requires = new HashSet<>();
            for (String require : taskDto.getRequires()) {
                requires.add(taskRepository.getByName(require));
            }
            task.setRequires(requires);
        }
        return task;
    }

    private void dtoToObject(TaskDto taskDto, Task task) {
        task.setName(taskDto.getName());
        task.setCommand(taskDto.getCommand());
    }
}