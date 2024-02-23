package com.jbunce.practiceexamhex.infraestructure.mappers;

import com.jbunce.practiceexamhex.domain.models.Task;
import com.jbunce.practiceexamhex.infraestructure.dao.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITaskMapper {

    Task toDomain(TaskEntity taskEntity);
    TaskEntity toEntity(Task task);

}
