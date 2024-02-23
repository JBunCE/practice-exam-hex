package com.jbunce.practiceexamhex.domain.models;

import com.jbunce.practiceexamhex.domain.models.value.objects.Status;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Task {

    private String uuid;
    private String title;
    private String description;
    private Status status;

}
