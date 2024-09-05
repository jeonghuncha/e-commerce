package jeonghuncha.practice.msa.userservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUser {
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not less than 2 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Size(min = 5, message = "Email not less than 5 characters")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Email not less than 8 characters")
    private String password;
}
