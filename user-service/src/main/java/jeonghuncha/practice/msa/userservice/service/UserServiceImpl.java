package jeonghuncha.practice.msa.userservice.service;

import jeonghuncha.practice.msa.userservice.dto.UserDto;
import jeonghuncha.practice.msa.userservice.jpa.UserEntity;
import jeonghuncha.practice.msa.userservice.jpa.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        userDto.setCreatedAt(new Date());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd("encrypted_password");

        userRepository.save(userEntity);

        UserDto updatedUserDto = mapper.map(userEntity, UserDto.class);

        return updatedUserDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        return null;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return null;
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        return null;
    }
}
