package com.example.pejon.controller;

import com.example.pejon.model.Role;
import com.example.pejon.model.Status;
import com.example.pejon.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/all")
    public List<Role> getAllRoles() {
        return roleService.getAllRole();
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }
    @PostMapping
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }
    @PostMapping("/{id}")
    public Role updateRoleById(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateRoleById(id, role);
    }
    @DeleteMapping("/{id}")
    public void deleteRoleById(@PathVariable Long id) {
        roleService.deleteRoleById(id);
    }
}
