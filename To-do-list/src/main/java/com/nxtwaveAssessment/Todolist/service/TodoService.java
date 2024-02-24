package com.nxtwaveAssessment.Todolist.service;

import com.nxtwaveAssessment.Todolist.model.ToDo;
import com.nxtwaveAssessment.Todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
   @Autowired
    ToDoRepository toDoRepository;

   public ToDo addTodo(ToDo todo){
       return toDoRepository.save(todo);

   }
    public List<ToDo> addTodo(List<ToDo> todo){
        return toDoRepository.saveAll(todo);

    }
    public List<ToDo> getAllTodo(){
       return toDoRepository.findAll();
    }
    public Optional<ToDo> getTodoById(Long id){
       return toDoRepository.findById(id);
    }
    public String updateTodoStatus(Long id, String status) {
        ToDo toDo = toDoRepository.findById(id).get();
        toDo.setStatus(status);
        toDoRepository.save(toDo);
        return toDo.getStatus();
    }
    public boolean deleteTodoById(Long id) {
        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
