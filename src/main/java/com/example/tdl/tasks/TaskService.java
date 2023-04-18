package com.example.tdl.tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTasksForUser(String user){

        log.info("fetching tasks for user {}", user);
        List<Task> listOfTasks = taskRepository.findByUsername(user);

        log.info("found {} tasks for {}", listOfTasks.size(), user);

        return listOfTasks;
    }

    public Task addNewTask(Task task){

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        try {

            task.setUsername(currentUser);

            log.info("attempting to save {} for {}", task, currentUser);

            Task savedTask = taskRepository.saveAndFlush(task);
            log.info("saved task with Id {}", savedTask.getId());
            return savedTask;
        }
        catch(Exception e){
            log.error("failed to save {} for {} to database", task, currentUser);
            throw new RuntimeException(e);
        }


    }
}
