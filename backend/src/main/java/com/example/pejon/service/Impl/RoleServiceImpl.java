package com.example.pejon.service.Impl;

import com.example.pejon.model.Role;
import com.example.pejon.model.Status;
import com.example.pejon.repository.RoleRepository;
import com.example.pejon.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Role не найден:" + id));
    }

    @Override
    public Role addRole(Role role) {
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role updateRoleById(Long id, Role role) {
        Role r = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role не найден: " + id));

        r.setName(role.getName());

        roleRepository.save(r);
        return r;
    }

    @Override
    public void deleteRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Role не найден: " + id));
        roleRepository.delete(role);
    }
}
