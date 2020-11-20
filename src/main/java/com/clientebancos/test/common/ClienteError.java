package com.clientebancos.test.common;

public class ClienteError {
    private String code;

    public ClienteError(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                '}';
    }
}
