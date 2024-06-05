package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentProgressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentProgressServiceImpl studentProgressService;

    //----------------------- Endpoints for Achievements ------------------------

    @GetMapping("/achievements")
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        List<Achievement> achievements = courseService.getAllAchievements();
        return ResponseEntity.ok(achievements);
    }

    @GetMapping("/achievements/{id}")
    public ResponseEntity<Achievement> getAchievementById(@PathVariable Long id) {
        Achievement achievement = courseService.getAchievementById(id);
        return achievement != null ? ResponseEntity.ok(achievement) : ResponseEntity.notFound().build();
    }

    @GetMapping("/achievements/name/{name}")
    public ResponseEntity<Achievement> getAchievementByName(@PathVariable String name) {
        Achievement achievement = courseService.getAchievementByName(name);
        return achievement != null ? ResponseEntity.ok(achievement) : ResponseEntity.notFound().build();
    }

    @PostMapping("/achievements")
    public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement achievement) {
        courseService.createAchievement(achievement);
        return ResponseEntity.ok(achievement);
    }

    @DeleteMapping("/achievements/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Long id) {
        courseService.deleteAchievement(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/achievements")
    public ResponseEntity<Achievement> updateAchievement(@RequestBody Achievement achievement) {
        courseService.updateAchievement(achievement);
        return ResponseEntity.ok(achievement);
    }

    //----------------------- Endpoints for Courses ----------------------------

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return ResponseEntity.ok(course);
    }

    //----------------------- Endpoints for Lectures ----------------------------

    @GetMapping("/lectures")
    public ResponseEntity<List<Lecture>> getAllLectures() {
        List<Lecture> lectures = courseService.getAllLectures();
        return ResponseEntity.ok(lectures);
    }

    @GetMapping("/lectures/{id}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Long id) {
        Lecture lecture = courseService.getLectureById(id);
        return lecture != null ? ResponseEntity.ok(lecture) : ResponseEntity.notFound().build();
    }

    @PostMapping("/lectures")
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture) {
        courseService.createLecture(lecture);
        return ResponseEntity.ok(lecture);
    }

    @DeleteMapping("/lectures/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        courseService.deleteLecture(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/lectures")
    public ResponseEntity<Lecture> updateLecture(@RequestBody Lecture lecture) {
        courseService.updateLecture(lecture);
        return ResponseEntity.ok(lecture);
    }

    //----------------------- Endpoints for Quizzes ----------------------------

    @GetMapping("/quizzes")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = courseService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/quizzes/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Quiz quiz = courseService.getQuizById(id);
        return quiz != null ? ResponseEntity.ok(quiz) : ResponseEntity.notFound().build();
    }

    @PostMapping("/quizzes")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        courseService.createQuiz(quiz);
        return ResponseEntity.ok(quiz);
    }

    @DeleteMapping("/quizzes/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        courseService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/quizzes")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        courseService.updateQuiz(quiz);
        return ResponseEntity.ok(quiz);
    }

    //----------------------- Endpoints for Student Progress ----------------------------

    @GetMapping("/student-progress")
    public ResponseEntity<List<StudentProgress>> getAllStudentProgress() {
        List<StudentProgress> studentProgressList = studentProgressService.getAllStudentProgress();
        return ResponseEntity.ok(studentProgressList);
    }

    @GetMapping("/student-progress/{id}")
    public ResponseEntity<StudentProgress> getStudentProgressById(@PathVariable Long id) {
        Optional<StudentProgress> studentProgress = studentProgressService.getStudentProgressById(id);
        return studentProgress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/student-progress/user/{userId}")
    public ResponseEntity<StudentProgress> getStudentProgressByUserId(@PathVariable Long userId) {
        Optional<StudentProgress> studentProgress = studentProgressService.getStudentProgressByUserId(userId);
        return studentProgress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/student-progress")
    public ResponseEntity<StudentProgress> createStudentProgress(@RequestBody StudentProgress studentProgress) {
        StudentProgress createdProgress = studentProgressService.saveStudentProgress(studentProgress);
        return ResponseEntity.ok(createdProgress);
    }

    @PutMapping("/student-progress/{id}")
    public ResponseEntity<StudentProgress> updateStudentProgress(@PathVariable Long id, @RequestBody StudentProgress studentProgress) {
        try {
            StudentProgress updatedProgress = studentProgressService.updateStudentProgress(id, studentProgress);
            return ResponseEntity.ok(updatedProgress);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/student-progress/{id}")
    public ResponseEntity<Void> deleteStudentProgress(@PathVariable Long id) {
        studentProgressService.deleteStudentProgress(id);
        return ResponseEntity.noContent().build();
    }
}
