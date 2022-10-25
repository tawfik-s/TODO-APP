package org.example.controller;

import org.example.entity.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    private void setTaskDao(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/list")
    public String listCustomer(Model model){
        //get tasks from Dao
        List<Task> tasks=taskService.getTasks();

        //add the customers to models
        model.addAttribute("tasks",tasks);

        return "list_tasks";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Task task=new Task();

        model.addAttribute("task",task);

        return "task_form";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.saveTask(task);
        return "redirect:/task/list";
    }

}
