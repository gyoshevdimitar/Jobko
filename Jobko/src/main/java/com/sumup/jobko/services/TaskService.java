package com.sumup.jobko.services;

import com.sumup.jobko.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> process();

    void create(Task task);

    void update(Task task);

    void delete(int id);

    List<Task> getAll();

    Task getById(int id);

    Task getByName(String name);
}