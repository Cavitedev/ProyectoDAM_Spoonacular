package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio;

public class DataSourceException extends Exception {

    int code = 0;
    String message = null;

    public DataSourceException() {
    }

    public DataSourceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
