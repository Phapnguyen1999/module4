package com.codegym.controller.rest;

import com.codegym.model.dto.RoleDTO;
import com.codegym.model.dto.UserDTO;
import com.codegym.service.role.IRoleService;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleRestController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<?> getListRole() {
        List<RoleDTO> roles = roleService.getAllRole();
        if (roles == null) {
            return new ResponseEntity<>("Danh sach trong!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserByRoleId(@PathVariable Long id) {
        List<UserDTO> userDTOS = userService.findUserDTOByRoleIdAndDeletedIsFalse(id);
        if (userDTOS == null) {
            return new ResponseEntity<>("Danh sách trống!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }
}
