package com.auGrad.Backend.exception;

public class NoObjectFoundException extends RuntimeException{
    public NoObjectFoundException(String mssg){
        super(mssg);
    }
}
