package com.example.jdbcsandbox;

import com.example.jdbcsandbox.domain.Sample;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class JdbcSandboxApplicationTests {

  @Test
  void contextLoads() throws IOException {

    ClassPathResource classPathResource = 
        new ClassPathResource("/data/sample.json");

    StringBuilder sb = new StringBuilder();

    BufferedReader br = 
        new BufferedReader(
            new InputStreamReader(classPathResource.getInputStream())
        );
    
    String s;
    while ((s = br.readLine()) != null) {

      sb.append(s);
    }

    ObjectMapper om = new ObjectMapper();

    Sample sample = om.readValue(sb.toString(), Sample.class);

    System.out.println(sample);    
  }

}
