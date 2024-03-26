package com.example.jdbcsandbox.domain;

import lombok.Getter;

/**
 * author : ms.Lee
 * date   : 2024-03-26
 */
@Getter
public class UserDTO {
  
  private final String name;
  private final String gender;

  public UserDTO(String name, String gender) {

    this.name = name;
    this.gender = gender;
  }

  public static UserDTO of(User user) {

    return new UserDTO(user.getName(), user.getGender());
  }
}
