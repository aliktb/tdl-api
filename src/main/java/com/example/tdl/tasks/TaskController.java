package com.example.tdl.tasks;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable String username){

        return ResponseEntity.ok(taskService.getAllTasksForUser(username));
    }

    @PostMapping("/new")
    public ResponseEntity<Task> addNewTask(@RequestBody Task taskBody){

        Task savedTask = taskService.addNewTask(taskBody);

        return ResponseEntity.ok(savedTask);
    }

}
