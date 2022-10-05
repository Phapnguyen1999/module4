package com.codegym.service.user;

import com.codegym.model.User;
import com.codegym.model.dto.UserDTO;
import com.codegym.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User getByUsername(String username);

    Optional<UserDTO> findUserDTOByUsername(String username);

    Optional<UserDTO> findUserById(Long id);

    List<UserDTO> findAllUserDTOByDeletedIsFailse();

    List<UserDTO> findUserDTOByRoleIdAndDeletedIsFalse(Long id);

    List<UserDTO> findUserByValue(String query);

}
