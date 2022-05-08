package com.example.demo.domain.enums;

import lombok.Getter;

@Getter
public enum TaskState {
    TO_DO("To do"),
    DONE("Done"),
    IN_PROGRESS("In progress");

    private String description;

    TaskState(String description) {
        this.description = description;
    }
}
