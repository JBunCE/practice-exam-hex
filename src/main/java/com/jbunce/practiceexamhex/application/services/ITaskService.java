package com.jbunce.practiceexamhex.application.services;

import com.jbunce.practiceexamhex.domain.models.Task;
import com.jbunce.practiceexamhex.domain.models.BaseResponse;
import com.jbunce.practiceexamhex.domain.models.value.objects.Status;

public interface ITaskService {

    BaseResponse getAllTasks();

    BaseResponse getTaskById(String id);

    BaseResponse createTask(Task task);

    BaseResponse changeTaskStatus(String id, Status status);

    BaseResponse deleteTask(String id);

}
