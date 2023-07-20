package com.mgbt.springauthdemo.services;

import com.mgbt.springauthdemo.entities.Role;
import com.mgbt.springauthdemo.entities.RolesEnum;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findByName(RolesEnum role);
}
