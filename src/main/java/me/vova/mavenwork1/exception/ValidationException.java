package me.vova.mavenwork1.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String entity){
        super("Ошибка валидации сущности: " + entity);
    }
}
