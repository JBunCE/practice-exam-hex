package com.jbunce.practiceexamhex.infraestructure.repositories;

import com.jbunce.practiceexamhex.domain.models.Task;
import com.jbunce.practiceexamhex.infraestructure.dao.TaskEntity;
import com.jbunce.practiceexamhex.infraestructure.mappers.ITaskMapper;
import com.jbunce.practiceexamhex.infraestructure.repositories.interfaces.ITaskRepository;
import com.jbunce.practiceexamhex.infraestructure.repositories.interfaces.jpa.JpaITaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskRepository implements ITaskRepository {

    @Autowired
    private JpaITaskRepository jpaRepository;

    @Autowired
    private ITaskMapper taskMapper;

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll().stream().map(taskMapper::toDomain).toList();
    }

    @Override
    public Task findById(String id) {
        TaskEntity taskEntity = jpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return taskMapper.toDomain(taskEntity);
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = taskMapper.toEntity(task);
        return taskMapper.toDomain(jpaRepository.save(taskEntity));
    }

    @Override
    public void deleteById(String id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void delete(Task task) {
        TaskEntity taskEntity = taskMapper.toEntity(task);
        jpaRepository.delete(taskEntity);
    }

}
