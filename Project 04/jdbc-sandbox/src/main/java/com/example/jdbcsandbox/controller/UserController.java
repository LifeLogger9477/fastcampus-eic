package com.example.jdbcsandbox.controller;

import com.example.jdbcsandbox.domain.UserDTO;
import com.example.jdbcsandbox.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-03-26
 */
@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {

    this.userService = userService;
  }

  @PostMapping(value = "/api/v1/users")
  public UserDTO create(
      @RequestParam String name,
      @RequestParam String gender
  ) {

    return userService.create(name, gender);
  }

  @GetMapping(value = "/api/v1/users/gender/{gender}")
  public List<UserDTO> findByGender(@PathVariable String gender) {

    return userService.findByGender(gender);
  }

  @PutMapping(value = "/api/v1/users/{id}")
  public UserDTO updateName(
      @PathVariable Integer id,
      @RequestParam String name
  ) {

    return userService.updateName(id, name);
  }

  @DeleteMapping(value = "/api/v1/users/{id}")
  public UserDTO delete(@PathVariable Integer id) {

    return userService.delete(id);
  }
}
