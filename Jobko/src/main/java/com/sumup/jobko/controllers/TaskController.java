package com.sumup.jobko.controllers;

import com.sumup.jobko.models.InputDto;
import com.sumup.jobko.models.Task;
import com.sumup.jobko.models.TaskDto;
import com.sumup.jobko.services.TaskService;
import com.sumup.jobko.utilities.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/job")
    public List<Task> job(@RequestBody InputDto inputDto) {
        for (TaskDto taskDto : inputDto.getTasks()) {
            create(taskDto);
        }
        for (TaskDto taskDto : inputDto.getTasks()) {
            update(taskService.getByName(taskDto.getName()).getId(), taskDto);
        }
        return getAll();
    }

    @PostMapping
    public Task create(@Valid @RequestBody TaskDto taskDto) {
        Task task = modelMapper.fromDto(taskDto);
        taskService.create(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable int id,
                       @Valid @RequestBody TaskDto taskDto) {
        Task task = modelMapper.fromDto(taskDto, id);
        taskService.update(task);
        return task;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        taskService.delete(id);
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return taskService.getById(id);
    }

    @GetMapping("/name")
    public Task getByName(@RequestParam String name) {
        return taskService.getByName(name);
    }
}