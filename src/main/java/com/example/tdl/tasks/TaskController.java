package com.example.tdl.tasks;

import com.fasterxml.jackson.databind.node.TextNode;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
