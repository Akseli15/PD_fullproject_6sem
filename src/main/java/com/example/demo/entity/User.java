package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", columnDefinition = "TEXT")
    private String username;

    @Column(name = "password", columnDefinition = "TEXT")
    private String password;

    @Column(name = "email", columnDefinition = "TEXT")
    private String email;

    @ManyToOne
    @JoinColumn(name = "fk_role_id", referencedColumnName = "role_id", foreignKey = @ForeignKey(name = "fk_role_id"))
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<StudentProgress> progress;

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
