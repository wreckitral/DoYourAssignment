package com.wreckitral.DoYourAssignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wreckitral.DoYourAssignment.model.TodoItem;
import com.wreckitral.DoYourAssignment.service.TodoItemService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
public class TodoFormController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = new TodoItem();

        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());
        
        todoItemService.save(todoItem);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem item = todoItemService.getById(id)
            .orElseThrow(() -> new IllegalArgumentException("Assigment id: " + id + " not found"));

        todoItemService.delete(item);

        return "redirect:/";
    }
}
