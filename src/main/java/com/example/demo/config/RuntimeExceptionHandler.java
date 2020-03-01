
package com.example.demo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RuntimeExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity handleRuntime(RuntimeException ex, WebRequest webRequest) {

        return ResponseEntity.status(500).body("some is gone wrong,please try later");

    }
}

