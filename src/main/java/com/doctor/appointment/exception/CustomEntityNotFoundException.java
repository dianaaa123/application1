
package com.doctor.appointment.exception;

import java.util.Locale;

public class CustomEntityNotFoundException extends Exception{
    private String entity;

    public CustomEntityNotFoundException(Class<?> cause){
        super(cause.getSimpleName());
        this.entity = cause.getSimpleName();
    }

    public String getErrorMessage(){
        return entity.toUpperCase() + "_NOT_FOUND";
    }
}