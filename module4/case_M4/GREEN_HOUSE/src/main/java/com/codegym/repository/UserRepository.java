package com.codegym.repository;

import com.codegym.model.User;
import com.codegym.model.dto.ProductDTO;
import com.codegym.model.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    @Query("SELECT NEW com.codegym.model.dto.UserDTO (u.id,u.fullName, u.password,u.phone, u.username,u.role)  FROM User u  WHERE u.deleted = false AND u.id = ?1 ")
    Optional<UserDTO> findUserById(Long id);

    @Query("SELECT NEW com.codegym.model.dto.UserDTO (u.id, u.username) FROM User u WHERE u.username = ?1")
    Optional<UserDTO> findUserDTOByUsername(String username);

    @Query("SELECT NEW com.codegym.model.dto.UserDTO (u.id,u.fullName,u.password, u.phone, u.username,u.role)  FROM User u  WHERE u.deleted = false ")
    List<UserDTO> findAllUserDTOByDeletedIsFalse();
    @Query("SELECT NEW com.codegym.model.dto.UserDTO (" +
            "u.id," +
            "u.fullName," +
            "u.password, " +
            "u.phone, " +
            "u.username," +
            "u.role)  FROM User u  WHERE u.deleted = false AND u.role.id = :id ")
    List<UserDTO> findUserDTOByRoleIdAndDeletedIsFalse(@Param("id") Long id);
    @Query("SELECT NEW com.codegym.model.dto.UserDTO ( " +
            "u.id, " +
            "u.fullName, " +
            "u.phone, " +
            "u.username, " +
            "u.role) " +
            "FROM User  u WHERE  " +
            " u.fullName like %?1% OR u.username like %?1% "  )
    List<UserDTO> findUserByValue(String query);


}
