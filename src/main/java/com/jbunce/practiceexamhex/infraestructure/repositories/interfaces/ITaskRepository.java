package com.jbunce.practiceexamhex.infraestructure.repositories.interfaces;

import com.jbunce.practiceexamhex.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository {

    List<Task> findAll();
    Task findById(String id);
    Task save(Task task);
    void deleteById(String id);
    void delete(Task task);

}
