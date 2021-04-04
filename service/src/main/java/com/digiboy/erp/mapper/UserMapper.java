package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.UserDTO;
import com.digiboy.erp.to.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends EntityMapper<User, UserDTO> {
}
