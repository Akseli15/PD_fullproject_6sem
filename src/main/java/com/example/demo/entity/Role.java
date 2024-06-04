package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name="role")
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "role_id")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "name")
    private String name;
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private List<User> user;

    public Role() {
    }

    public Role(Long id, String name, List<User> user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }
}
