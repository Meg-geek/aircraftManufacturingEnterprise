package com.nsu.bd.aircraft.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GeneralResponse<T> {
    private final Status status;
    private final T data;
    private final ErrorCause cause;

    public GeneralResponse(Status status, ErrorCause cause) {
        this.status = status;
        this.cause = cause;
        this.data = null;
    }

    public GeneralResponse(Status status) {
        this.status = status;
        this.data = null;
        this.cause = null;
    }

    public GeneralResponse(T data) {
        this.status = Status.OK;
        this.data = data;
        this.cause = null;
    }

    public static GeneralResponse<?> ok() {
        return new GeneralResponse<>(Status.OK);
    }
}
