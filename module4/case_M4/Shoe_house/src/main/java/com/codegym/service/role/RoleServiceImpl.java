package com.codegym.service.role;

import com.codegym.model.Role;
import com.codegym.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleService implements IRoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role getById(Long id) {
        return null;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void softDelete(Role role) {

    }
}
