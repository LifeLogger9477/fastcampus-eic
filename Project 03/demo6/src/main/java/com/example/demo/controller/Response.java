package com.example.demo.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Getter
public class Response<T> {    // 공통으로 사용하기 위해

  private final HttpStatus statusCode;
  private final String message;
  private final T data;

  public Response(HttpStatus statusCode, String message, T data) {
    
    this.statusCode = statusCode;
    this.message = message;
    this.data = data;
  }

  public static <T> Response<T> success(T data) {

    return new Response<>(HttpStatus.OK, "SUCCESS", data);
  }

  public static <T> Response<T> fail(String errorMessage) {   // 실패의 경우 data 없음

    return new Response<>(
        HttpStatus.INTERNAL_SERVER_ERROR, 
        errorMessage, 
        null
    );
  }
}
