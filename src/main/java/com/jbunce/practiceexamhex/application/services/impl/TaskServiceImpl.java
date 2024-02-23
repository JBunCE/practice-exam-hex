package com.jbunce.practiceexamhex.application.services.impl;

import com.jbunce.practiceexamhex.application.services.ITaskService;
import com.jbunce.practiceexamhex.domain.models.Task;
import com.jbunce.practiceexamhex.domain.models.BaseResponse;
import com.jbunce.practiceexamhex.domain.models.value.objects.Status;
import com.jbunce.practiceexamhex.domain.models.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository repository;

    @Override
    public BaseResponse getAllTasks() {
        List<Task> tasks = repository.findAll();

        return BaseResponse.builder()
                .data(tasks)
                .message("The tasks were found")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value()).build();
    }

    @Override
    public BaseResponse getTaskById(String id) {
        Task task = repository.findById(id);

        return BaseResponse.builder()
                .data(task)
                .message("The task with id: " + id + " was found")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value()).build();
    }

    @Override
    public BaseResponse createTask(Task task) {
        Task savedTask = repository.save(task);

        return BaseResponse.builder()
                .data(savedTask)
                .message("The task was created")
                .success(Boolean.TRUE)
                .status(HttpStatus.CREATED)
                .code(HttpStatus.CREATED.value()).build();
    }

    @Override
    public BaseResponse changeTaskStatus(String id, Status status) {
        Task task = repository.findById(id);

        task.setStatus(status);
        Task savedTask = repository.save(task);

        return BaseResponse.builder()
                .data(savedTask)
                .message("The task status was changed")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value()).build();
    }

    @Override
    public BaseResponse deleteTask(String id) {
        repository.deleteById(id);

        return BaseResponse.builder()
                .message("The task was deleted")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value()).build();
    }
}
