package com.nxtwaveAssessment.Todolist.repository;

import com.nxtwaveAssessment.Todolist.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    @Override
    Optional<ToDo> findById(Long aLong);
    List<ToDo> findAll();
    @Override
    void deleteById(Long aLong);
}