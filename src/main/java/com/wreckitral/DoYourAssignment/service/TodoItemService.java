package com.wreckitral.DoYourAssignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wreckitral.DoYourAssignment.model.TodoItem;
import com.wreckitral.DoYourAssignment.repository.TodoItemRepository;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }
}



