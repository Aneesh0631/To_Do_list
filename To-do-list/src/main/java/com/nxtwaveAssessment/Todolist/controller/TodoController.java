package com.nxtwaveAssessment.Todolist.controller;

import com.nxtwaveAssessment.Todolist.model.ToDo;
import com.nxtwaveAssessment.Todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<String> addToDo(@RequestBody ToDo todo){
        todoService.addTodo(todo);
        return new ResponseEntity<>("Success" , HttpStatus.OK);
    }
    @PostMapping("/todos")
    public ResponseEntity<String> addToDo(@RequestBody List<ToDo> todo){
        todoService.addTodo(todo);
        return new ResponseEntity<>("Success" , HttpStatus.OK);
    }
    @GetMapping("/gettodo")
    public List<ToDo> getTodo(){
       return todoService.getAllTodo();
    }
    @GetMapping("/getToDo/{id}")
    public Optional<ToDo> getTodo(@PathVariable Long id){
        return todoService.getTodoById(id);
    }
    @PutMapping("/todos/{id}/update-status")
    public ResponseEntity<String> updateTodoStatus(@PathVariable Long id, @RequestParam String newStatus) {
        String updatedTodo = todoService.updateTodoStatus(id,newStatus);
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        boolean deleted = todoService.deleteTodoById(id);

        if (deleted) {
            return ResponseEntity.ok(" Todo id "+ id+ " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
