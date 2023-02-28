package com.sumup.jobko.models;

import java.util.Set;

public class InputDto {
    private Set<TaskDto> tasks;

    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDto> tasks) {
        this.tasks = tasks;
    }
}