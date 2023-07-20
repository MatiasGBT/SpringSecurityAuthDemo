package com.mgbt.springauthdemo.services.impl;

import com.mgbt.springauthdemo.entities.Role;
import com.mgbt.springauthdemo.entities.RolesEnum;
import com.mgbt.springauthdemo.exceptions.NotFoundException;
import com.mgbt.springauthdemo.repositories.RoleRepository;
import com.mgbt.springauthdemo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(RolesEnum role) {
        return roleRepository.findByName(role).orElseThrow(() -> new NotFoundException("Role not found"));
    }
}
