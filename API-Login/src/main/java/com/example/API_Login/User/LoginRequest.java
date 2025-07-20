package com.example.API_Login.User;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
