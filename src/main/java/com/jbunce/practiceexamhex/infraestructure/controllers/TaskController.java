package com.jbunce.practiceexamhex.infraestructure.controllers;

import com.jbunce.practiceexamhex.application.services.ITaskService;
import com.jbunce.practiceexamhex.domain.models.BaseResponse;
import com.jbunce.practiceexamhex.domain.models.Task;
import com.jbunce.practiceexamhex.domain.models.value.objects.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskService service;

    @GetMapping
    public ResponseEntity<BaseResponse> getAllTasks() {
        return service.getAllTasks().apply();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getTaskById(@RequestParam String id) {
        return service.getTaskById(id).apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createTask(@RequestBody Task task) {
        return service.createTask(task).apply();
    }

    @PutMapping
    public ResponseEntity<BaseResponse> updateTask(@RequestParam String id, @RequestParam Status status) {
        return service.changeTaskStatus(id, status).apply();
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> deleteTask(@RequestParam String id) {
        return service.deleteTask(id).apply();
    }

}
