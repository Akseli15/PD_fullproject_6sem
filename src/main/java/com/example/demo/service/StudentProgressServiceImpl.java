package com.example.demo.service;

import com.example.demo.entity.StudentProgress;
import com.example.demo.entity.User;
import com.example.demo.repository.StudentProgressRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProgressServiceImpl implements StudentProgressService {

    @Autowired
    private StudentProgressRepository studentProgressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public StudentProgress saveStudentProgress(StudentProgress studentProgress) {
        return studentProgressRepository.save(studentProgress);
    }

    @Override
    public Optional<StudentProgress> getStudentProgressById(Long id) {
        return studentProgressRepository.findById(id);
    }

    @Override
    public List<StudentProgress> getAllStudentProgress() {
        return studentProgressRepository.findAll();
    }

    @Override
    public StudentProgress updateStudentProgress(Long id, StudentProgress studentProgress) {
        Optional<StudentProgress> existingProgress = studentProgressRepository.findById(id);
        if (existingProgress.isPresent()) {
            StudentProgress updatedProgress = existingProgress.get();
            updatedProgress.setUser(studentProgress.getUser());
            updatedProgress.setCourseResults(studentProgress.getCourseResults());
            updatedProgress.setLectureResults(studentProgress.getLectureResults());
            updatedProgress.setQuizResults(studentProgress.getQuizResults());
            updatedProgress.setAchievements(studentProgress.getAchievements());
            return studentProgressRepository.save(updatedProgress);
        } else {
            throw new RuntimeException("StudentProgress not found with id " + id);
        }
    }

    @Override
    public void deleteStudentProgress(Long id) {
        studentProgressRepository.deleteById(id);
    }

    @Override
    public Optional<StudentProgress> getStudentProgressByUserId(Long userId) {
        return studentProgressRepository.findByUserId(userId);
    }

    @Override
    public List<StudentProgress> getAllStudentProgressByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return studentProgressRepository.findByUser(user);
        } else {
            throw new RuntimeException("User not found with id " + userId);
        }
    }
}
