package com.sumup.jobko.repositories;

import com.sumup.jobko.models.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getAll();

    Task getById(int id);

    Task getByName(String name);

    void create(Task task);

    void update(Task task);

    void delete(int id);
}
