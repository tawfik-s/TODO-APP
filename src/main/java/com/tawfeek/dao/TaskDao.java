package com.tawfeek.dao;

import com.tawfeek.entity.Task;

import java.util.List;

public interface TaskDao {
    public List<Task> getTasks();

    void saveTask(Task task);

    Task getTask(long theId);

    void deleteTask(long theId);
}
