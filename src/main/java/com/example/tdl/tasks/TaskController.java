package com.example.tdl.tasks;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/tasks", produces = "application/json")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping("/user")
    public ResponseEntity<List<Task>> getAllTasks(){

        return ResponseEntity.ok(taskService.getAllTasksForUser());
    }

    @PostMapping("/new")
    public ResponseEntity<Task> addNewTask(@RequestBody Task taskBody){

        Task savedTask = taskService.addNewTask(taskBody);

        return ResponseEntity.ok(savedTask);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){


        taskService.deleteTaskById(taskId);

        return ResponseEntity.noContent().build();
    }

}
