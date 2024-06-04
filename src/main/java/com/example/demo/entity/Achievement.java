package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "achievement")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column(name = "image", columnDefinition = "BYTEA")
    private byte[] image;

    public Achievement() {
    }

    public Achievement(String name, String description, byte[] image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
