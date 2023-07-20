package com.mgbt.springauthdemo.services.impl;

import com.mgbt.springauthdemo.config.security.UserDetailsImpl;
import com.mgbt.springauthdemo.entities.User;
import com.mgbt.springauthdemo.exceptions.NotFoundException;
import com.mgbt.springauthdemo.repositories.UserRepository;
import com.mgbt.springauthdemo.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long idUser) {
        return userRepository.findById(idUser).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));
        return UserDetailsImpl.build(user);
    }
}
