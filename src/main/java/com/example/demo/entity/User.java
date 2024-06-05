package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
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

    @Column(name = "\"group\"", columnDefinition = "TEXT")
    private String group;

    @Column(name = "number", columnDefinition = "TEXT")
    private String number;

    @Column(name = "course", columnDefinition = "TEXT")
    private String course;

    @ManyToOne
    @JoinColumn(name = "fk_role_id", referencedColumnName = "role_id", foreignKey = @ForeignKey(name = "fk_role_id"))
    @JsonIgnoreProperties("user")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<StudentProgress> progress;

    public User() {
    }

    public User(Long id, String username, String password, String email, String group, String number, String course, Role role, List<StudentProgress> progress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.group = group;
        this.number = number;
        this.course = course;
        this.role = role;
        this.progress = progress;
    }
}
