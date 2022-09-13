package com.challenge.Auth.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Data
public class UserDTO
{
    @Email(message="Username must be an email")
    private String userName;
    @Size(min =0)
    private String password;
}
