package com.sumup.jobko.utilities;

import com.sumup.jobko.models.Task;
import com.sumup.jobko.models.TaskDto;
import com.sumup.jobko.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return task;
    }

    public TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setName(task.getName());
        taskDto.setCommand(task.getCommand());
        return taskDto;
    }

    private void dtoToObject(TaskDto taskDto, Task task) {
        task.setName(taskDto.getName());
        task.setCommand(taskDto.getCommand());
    }
}
