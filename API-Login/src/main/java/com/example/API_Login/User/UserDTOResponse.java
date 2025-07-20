package com.example.API_Login.User;

public record UserDTOResponse(Long id,String email, String login) {
    public UserDTOResponse(User user){
        this(user.getId(), user.getEmail(), user.getLogin());
    }
}
