package com.micro.userservice.service;

import com.micro.userservice.dto.UserDTO;
import com.micro.userservice.model.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);
    User findByCpf(String cpf);
    boolean deleteByCpf(String cpf);
    List<User> findAll();
    User save(User user);
    User atualizar(User u, UserDTO dto);
}