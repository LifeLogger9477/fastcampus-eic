package com.example.aopsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class AopSandboxApplication {

  public static void main(String[] args) {

    SpringApplication.run(AopSandboxApplication.class, args);
  }

}
