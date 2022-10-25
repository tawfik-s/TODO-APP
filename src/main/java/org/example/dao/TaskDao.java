package org.example.dao;

import org.example.entity.Task;

import java.util.List;

public interface TaskDao {
    public List<Task> getTasks();

    void saveTask(Task task);
}
