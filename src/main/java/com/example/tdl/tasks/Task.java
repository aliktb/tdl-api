package com.example.tdl.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    public Task(String user, Date dueDate, boolean complete) {
        this.username = user;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;
    private String username;
    private Date dueDate;
    private boolean complete;



}
