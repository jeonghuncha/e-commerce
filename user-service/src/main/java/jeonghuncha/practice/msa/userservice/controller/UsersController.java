package jeonghuncha.practice.msa.userservice.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1")
public class UsersController {
    private Environment env;

    public UsersController(Environment env) {
        this.env = env;
    }

    @GetMapping("/status_check")
    public String status() {
        return "It's Working on User Service on PORT " + env.getProperty("local.server.port");
    }
}
