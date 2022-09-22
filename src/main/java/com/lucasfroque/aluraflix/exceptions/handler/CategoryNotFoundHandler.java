package com.lucasfroque.aluraflix.exceptions.handler;

import com.lucasfroque.aluraflix.exceptions.CategoryNotFoundException;
import com.lucasfroque.aluraflix.exceptions.handler.models.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryNotFoundHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(CategoryNotFoundException e){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(e.getMessage(), error, status.value());
        return ResponseEntity.status(status).body(err);
    }
}
