package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name", columnDefinition = "TEXT")
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
