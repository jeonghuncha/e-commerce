package jeonghuncha.practice.msa.userservice.service;

import jeonghuncha.practice.msa.userservice.dto.UserDto;
import jeonghuncha.practice.msa.userservice.jpa.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String email);
}
