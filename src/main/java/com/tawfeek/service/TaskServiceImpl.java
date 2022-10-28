package com.tawfeek.service;

import com.tawfeek.dao.TaskDao;
import com.tawfeek.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskDao taskDao;

    @Autowired
    public void setTaskDao(TaskDao taskDao){
        this.taskDao=taskDao;
    }

    @Transactional
    public List<Task> getTasks() {
        return taskDao.getTasks();
    }

    @Transactional
    public void saveTask(Task task) {
        taskDao.saveTask(task);
    }

    @Transactional
    public Task getTask(long theId) {
        Task task=taskDao.getTask(theId);
        return task;
    }

    @Transactional
    public void deleteTask(long theId) {
        taskDao.deleteTask(theId);
    }
}
