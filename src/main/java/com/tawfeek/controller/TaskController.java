package com.tawfeek.controller;

import com.tawfeek.entity.Task;
import com.tawfeek.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("taskId") long theId,Model model){
        //get task from the database
        Task task=taskService.getTask(theId);
        //set the customer as a model attribute
        model.addAttribute("task",task);

        //send over to our form
        return "task_form";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam("taskId") long theId){

        taskService.deleteTask(theId);
        return "redirect:/task/list";
    }

}
