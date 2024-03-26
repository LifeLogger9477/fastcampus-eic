package com.example.jdbcsandbox.service;

import com.example.jdbcsandbox.domain.UserDTO;
import com.example.jdbcsandbox.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author : ms.Lee
 * date   : 2024-03-26
 */
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {

    this.userRepository = userRepository;
  }

  public UserDTO create(String name, String gender) {

    return UserDTO.of(userRepository.create(name, gender));
  }

  public List<UserDTO> findByGender(String gender) {
    
    return userRepository.findByGender(gender)
        .stream()
        .map(UserDTO::of)
        .collect(Collectors.toList());
  }
  
  public UserDTO updateName(int id, String name) {

    return UserDTO.of(userRepository.updateName(id, name));
  }

  public UserDTO delete(int id) {

    return UserDTO.of(userRepository.delete(id));
  }
}
