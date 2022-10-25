package org.example.service;

import org.example.entity.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getTasks();

    void saveTask(Task task);

    Task getTask(long theId);

    void deleteTask(long theId);
}
