package com.jbunce.practiceexamhex.domain.models.repositories;

import com.jbunce.practiceexamhex.domain.models.Task;

import java.util.List;

public interface ITaskRepository {

    List<Task> findAll();
    Task findById(String id);
    Task save(Task task);
    void deleteById(String id);
    void delete(Task task);

}
