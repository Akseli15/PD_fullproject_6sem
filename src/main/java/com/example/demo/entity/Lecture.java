package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Practice> practices;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    public Lecture() {
    }

    public Lecture(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
