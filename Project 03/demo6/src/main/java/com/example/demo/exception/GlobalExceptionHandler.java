package com.example.demo.exception;

import com.example.demo.controller.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * author : ms.Lee
 * date   : 2024-03-11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = RuntimeException.class)
  public Response<Void> handleRuntimeException(RuntimeException e) {

    return Response.fail(e.getMessage());
  }
}
