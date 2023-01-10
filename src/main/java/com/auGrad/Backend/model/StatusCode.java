package com.auGrad.Backend.model;

public class StatusCode {
    public StatusCode(String msg, boolean status) {
        this.msg = msg;
        this.status = status;
    }

    String msg;
    boolean status;
}
