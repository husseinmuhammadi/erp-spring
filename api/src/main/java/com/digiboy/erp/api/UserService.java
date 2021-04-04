package com.digiboy.erp.api;

import com.digiboy.erp.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<UserDTO> findAll(Pageable pageable);

    List<UserDTO> findAll();

    Optional<UserDTO> findById(String username);

    UserDTO save(UserDTO dto);

    void remove(String username);
}
