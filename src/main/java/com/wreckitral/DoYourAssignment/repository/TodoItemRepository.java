package com.wreckitral.DoYourAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wreckitral.DoYourAssignment.model.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
