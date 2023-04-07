package com.example.tdl.tasks;

import com.example.tdl.security.IAuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    public List<Task> getAllTasksForUser(){

    Authentication authentication = authenticationFacade.getAuthentication();
    String currentUser = authentication.getName();


        log.info("fetching tasks for user {}", currentUser);
        List<Task> listOfTasks = taskRepository.findByUsername(currentUser);

        log.info("found {} tasks for {}", listOfTasks.size(), currentUser);

        return listOfTasks;
    }

    public Task addNewTask(Task task){

        Authentication authentication = authenticationFacade.getAuthentication();
        String currentUser = authentication.getName();

        try {

            task.setUsername(currentUser);

            log.info("attempting to save {} for {}", task, currentUser);

            Task savedTask = taskRepository.saveAndFlush(task);
            log.info("saved task with Id {}", savedTask.getId());
            return savedTask;
        }
        catch(Exception e){
            log.error("failed to save {} for {} to database", task, currentUser, e);
            throw new RuntimeException(e);
        }


    }

    public void deleteTaskById(UUID taskId){

        Authentication authentication = authenticationFacade.getAuthentication();
        String currentUser = authentication.getName();

        log.info("attempting to delete Task with ID {} for user {}", taskId, currentUser);

        try{

            taskRepository.deleteById(taskId);
            log.info("deleted task {} for user {}", taskId, currentUser);

        }
        catch (Exception e){
            log.error("failed to delete task with ID {} for user {}", taskId, currentUser, e);
            throw new RuntimeException(e);
        }
    }
}
