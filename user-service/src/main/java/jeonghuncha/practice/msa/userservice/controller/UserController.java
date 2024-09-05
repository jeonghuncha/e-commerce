package jeonghuncha.practice.msa.userservice.controller;

import jeonghuncha.practice.msa.userservice.dto.UserDto;
import jeonghuncha.practice.msa.userservice.service.UserService;
import jeonghuncha.practice.msa.userservice.vo.RequestUser;
import jeonghuncha.practice.msa.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1")
public class UserController {
    private Environment env;
    private UserService userService;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/status_check")
    public String status() {
        return "It's Working on User Service on PORT " + env.getProperty("local.server.port");
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return new ResponseEntity(responseUser, HttpStatus.CREATED);
    }
}
