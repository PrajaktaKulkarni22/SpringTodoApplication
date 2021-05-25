package com.todoappproject.springtodoapp.controller;

import com.todoappproject.springtodoapp.model.TaskList;
import com.todoappproject.springtodoapp.repository.TaskRepository;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TaskController {

    @Autowired
    protected TaskRepository taskRepository;

    @PostMapping("/savetask")
    public TaskList saveTask(@RequestBody TaskList taskList){
       return taskRepository.save(taskList);
    }

    @GetMapping("/displaytask")
    public List<TaskList> displaytask(){
        return taskRepository.findAll();
    }

    @GetMapping("/taskbyid/{taskId}")
    public Optional<TaskList> getTaskById(@PathVariable Integer taskId){
        return taskRepository.findById(taskId);
    }

    @PutMapping("/updatetask/{taskId}")
    public TaskList updateTask(@PathVariable Integer taskId,@RequestBody TaskList taskList){
        Optional<TaskList> task=taskRepository.findById(taskId);

        task.get().setTaskName(taskList.getTaskName());
        return taskRepository.save(task.get());
    }

    @DeleteMapping("/deletetask/{taskId}")
    public String deleteTask(@PathVariable Integer taskId){
        taskRepository.deleteById(taskId);
        return "Task deleted";
    }

    @GetMapping("/searchtask/{keyword}")
    public List<TaskList> search(@PathVariable String keyword){
        return taskRepository.searchTask(keyword);
    }
}
