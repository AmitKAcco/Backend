package com.auGrad.Backend.model;

import lombok.Data;
import org.springframework.stereotype.Component;


//@Data
public class StatusCode {
    public StatusCode(String msg) {
        this.msg = msg;
//
    }

    String msg;
}
