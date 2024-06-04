package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "student_progress")
public class StudentProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Convert(converter = JsonConverter.class)
    @Column(name = "course_results", columnDefinition = "TEXT")
    private Map<String, Object> courseResults;

    @Convert(converter = JsonConverter.class)
    @Column(name = "lecture_results", columnDefinition = "TEXT")
    private Map<String, Object> lectureResults;

    @Convert(converter = JsonConverter.class)
    @Column(name = "quiz_results", columnDefinition = "TEXT")
    private Map<String, Object> quizResults;

    @Convert(converter = JsonConverter.class)
    @Column(name = "achievements", columnDefinition = "TEXT")
    private Map<String, Object> achievements;

    public StudentProgress() {
    }

    public StudentProgress(Long id, User user, Map<String, Object> courseResults, Map<String,
            Object> lectureResults, Map<String, Object> quizResults, Map<String, Object> achievements) {
        this.id = id;
        this.user = user;
        this.courseResults = courseResults;
        this.lectureResults = lectureResults;
        this.quizResults = quizResults;
        this.achievements = achievements;
    }
}
