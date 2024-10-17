package com.example.accessingdatajpa.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password; // Aquí se almacenará la contraseña hasheada

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    // Getters y setters
    public Long getId() { return id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Set<String> getRoles() { return roles; }

    public void setRoles(Set<String> roles) { this.roles = roles; }
}
