package com.mgbt.springauthdemo.services;

import com.mgbt.springauthdemo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();
    User findById(Long idUser);
    User findByUsername(String username);
    User save(User user);
    void delete(User user);
}
