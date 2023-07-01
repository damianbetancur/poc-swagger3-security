package com.poc_swagger3_security.security.repository;

import com.poc_swagger3_security.security.model.ERole;
import com.poc_swagger3_security.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
