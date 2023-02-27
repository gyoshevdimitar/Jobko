package com.sumup.jobko.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class TaskDto {
    @NotNull(message = "You must choose a name!")
    @Size(min = 1, max = 16, message = "Name should be made of 1 to 16 symbols!")
    private String name;

    @NotNull(message = "You must enter a command!")
    @Size(min = 1, max = 66, message = "Command should be made of 1 to 66 symbols!")
    private String command;

    private Set<Task> requirements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Set<Task> getRequirements() {
        return requirements;
    }

    public void setRequirements(Set<Task> requirements) {
        this.requirements = requirements;
    }
}