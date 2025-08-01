package com.example.API_Login.User;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;
    private String login;

    public User(UserDTORequest data) {
        this.email = data.email();
        this.password = data.password();
        this.login = data.login();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // ou use: List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
