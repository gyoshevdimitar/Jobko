package com.sumup.jobko.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "command")
    private String command;

    @ManyToMany
    @JoinTable(
            name = "tasks_requirements",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "requirement_id")
    )
    private Set<Task> requirements = new HashSet<>();

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
