package com.codegym.controller.rest;

import com.codegym.model.Customer;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.model.dto.ProductDTO;
import com.codegym.model.dto.UserDTO;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.product.IProductService;
import com.codegym.service.user.IUserService;
import com.codegym.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private AppUtils appUtils;
    @Autowired
    private IUserService userService;


    @GetMapping
    public ResponseEntity<?> showListUser() {

        Iterable<UserDTO> users = userService.findAllUserDTOByDeletedIsFailse();

        if (users == null) {
            return new ResponseEntity<>("Danh sách trống!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody UserDTO userDTO) {

//        if (bindingResult.hasErrors()) {
//            return appUtils.mapErrorToResponse(bindingResult);
//        }
        try {
            User user = userDTO.toUser();
            user.setId(0L);
            user.setDeleted(false);
            user = userService.save(user);

            return new ResponseEntity<>(user.toUserDTO(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Server ko xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<UserDTO> user = userService.findUserById(id);

        if (!user.isPresent()) {
            return new ResponseEntity<>("Không tìm thấy user có id là:" + id + "!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

//    @PutMapping("/block/{id}")
//    public ResponseEntity<?> doBlock(@PathVariable Long id, BindingResult bindingResult) {
//        Optional<User> user = userService.findById(id);
//
//        if (!user.isPresent()) {
//            return new ResponseEntity<>("Không tìm thấy user có id là:" + id + "!", HttpStatus.NO_CONTENT);
//        }
//
//        if (bindingResult.hasErrors()) {
//            return AppUtils.errors(bindingResult);
//        }
//
//        try {
////            if (user.get().get().getId() == 1) {
////                userService.blockCustomer(id);
////            } else {
////                customerService.unlockCustomer(id);
////            }
////
////
////            return new ResponseEntity<>(id, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Server không xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
