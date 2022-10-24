package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    @RequestMapping("/task/list")
    public String listCustomer(){
        return "list-tasks";
    }


}
