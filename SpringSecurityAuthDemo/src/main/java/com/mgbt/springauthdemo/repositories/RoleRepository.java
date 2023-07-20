package com.mgbt.springauthdemo.repositories;

import com.mgbt.springauthdemo.entities.Role;
import com.mgbt.springauthdemo.entities.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RolesEnum name);
}
