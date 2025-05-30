package com.example.pejon.service;

import com.example.pejon.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleById(Long id);
    Role addRole(Role role);
    Role updateRoleById(Long id, Role role);
    void deleteRoleById(Long id);
}
