package com.jbunce.practiceexamhex.infraestructure.repositories.interfaces.jpa;

import com.jbunce.practiceexamhex.infraestructure.dao.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaITaskRepository extends JpaRepository<TaskEntity, String> {


}
