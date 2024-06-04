package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "user_id")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "username")
    private String username;
    @Column(columnDefinition = "TEXT", name = "password")
    private String password;
    @Column(columnDefinition = "TIME", name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_role_id", referencedColumnName = "role_id", foreignKey = @ForeignKey(name = "fk_role_id"))
    private Role role;

    public User() {
    }

    public User(Long id, String username, String password, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
