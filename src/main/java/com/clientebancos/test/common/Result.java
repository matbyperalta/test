package com.clientebancos.test.common;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
    private T ok;
    private boolean validated = false;
    private List<ClienteError> errores = new ArrayList<>();

    public Result(T ok) {
        this.ok = ok;
    }

    public Result(ClienteError error) {
        this.errores.add(error);
    }

    public Result(List<ClienteError> errores) {
        this.errores.addAll(errores);
    }

    public T ok() throws RuntimeException {
        if (!validated || isError()) {
            throw new RuntimeException("OK no existe. Error");
        }
        return ok;
    }

    public Result addError(ClienteError error) {
        this.errores.add(error);
        return this;
    }

    public boolean isError() {
        validated = true;
        return this.errores.size() > 0;
    }

    public static <T> Result<T> ok(T ok) {
        return new Result<T>(ok);
    }

    public static <T> Result<T> ok(Result ok) {
        if (ok == null) {
            return new Result<T>((T) null);
        } else {
            return new Result<T>((T) ok.ok());
        }
    }

    public static Result error(Result error) {
        return error(error.getErrores());
    }

    public static Result error(ClienteError error) {
        return new Result(error);
    }

    public static Result error(String code) {
        return new Result(new ClienteError(code));
    }

    public static Result error(List<ClienteError> errores) {
        return new Result(errores);
    }

    public List<ClienteError> getErrores() {
        return errores;
    }

    public void setErrores(List<ClienteError> errores) {
        this.errores = errores;
    }

    @Override
    public String toString() {
        return "{" +
                "ok=" + ok +
                ", validated=" + validated +
                ", errores=" + errores +
                '}';
    }

    public T getOk() {
        return ok;
    }

    public void setOk(T ok) {
        this.ok = ok;
    }
}
