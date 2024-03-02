package com.example.aopsandbox.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/**
 * author : ms.Lee
 * date   : 2024-03-02
 */
@Aspect
@Component
public class LoggingAspect {

  @Around("within(com.example.aopsandbox.product.ProductController)")
  public void doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

    ZonedDateTime startAt = ZonedDateTime.now();
    System.out.println("메소드 시작");

    joinPoint.proceed();

    ZonedDateTime finishAt = ZonedDateTime.now();
    System.out.println(
        "메소드 종료... 수행 시간 = " +
        (finishAt.getNano() - startAt.getNano())
    );
  }
}
