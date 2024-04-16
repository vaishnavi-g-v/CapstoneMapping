package com.example.capstonemapping.Entity;

public enum RequestStatus {
    REQUESTED(0),
    ACCEPTED(1),
    REJECTED(-1);

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

    RequestStatus(int code) {
        this.code = code;
    }
}
