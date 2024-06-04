package com.example.demo.service;

import com.example.demo.entity.Achievement;
import com.example.demo.entity.Course;
import com.example.demo.entity.Lecture;
import com.example.demo.entity.Quiz;
import com.example.demo.repository.AchievementRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LectureRepository;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    AchievementRepository achievementRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    QuizRepository quizRepository;

    //----------------------- Сервисы достижений ------------------------

    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }

    public Achievement getAchievementById(Long id) {
        return achievementRepository.findById(id).orElse(null);
    }

    public Achievement getAchievementByName(String name) {
        return achievementRepository.findByName(name);
    }

    public void createAchievement(Achievement achievement) {
        achievementRepository.save(achievement);
    }

    public void deleteAchievement(Long id) {
        achievementRepository.deleteById(id);
    }

    public void updateAchievement(Achievement achievement) {
        Achievement existingAchievement = getAchievementById(achievement.getId());
        existingAchievement.setName(achievement.getName());
        existingAchievement.setDescription(achievement.getDescription());
        existingAchievement.setImage(achievement.getImage());
        achievementRepository.save(existingAchievement);
    }

    //----------------------- Сервисы курсов ----------------------------

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course updatedCourse) {
        Course existingCourse = getCourseById(updatedCourse.getId());
        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setLectures(updatedCourse.getLectures());
        courseRepository.save(existingCourse);
    }

    //----------------------- Сервисы лекций ----------------------------

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture getLectureById(Long id) {
        return lectureRepository.findById(id).orElse(null);
    }

    public void createLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

    public void updateLecture(Lecture updatedLecture) {
        Lecture existingLecture = getLectureById(updatedLecture.getId());
        existingLecture.setTitle(updatedLecture.getTitle());
        existingLecture.setContent(updatedLecture.getContent());
        existingLecture.setQuizzes(updatedLecture.getQuizzes());
        lectureRepository.save(existingLecture);
    }

    //----------------------- Сервисы квизов ----------------------------

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public void createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public void updateQuiz(Quiz updatedQuiz) {
        Quiz existingQuiz = getQuizById(updatedQuiz.getId());
        existingQuiz.setQuestion(updatedQuiz.getQuestion());
        existingQuiz.setAnswer(updatedQuiz.getAnswer());
        existingQuiz.setLecture(updatedQuiz.getLecture());
        quizRepository.save(existingQuiz);
    }
}
