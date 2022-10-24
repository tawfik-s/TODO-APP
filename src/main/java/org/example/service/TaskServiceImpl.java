package org.example.service;

import org.example.dao.TaskDao;
import org.example.entity.Task;
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
}