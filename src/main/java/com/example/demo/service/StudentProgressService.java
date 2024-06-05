package com.example.demo.service;

import com.example.demo.entity.StudentProgress;

import java.util.List;
import java.util.Optional;

public interface StudentProgressService {

    StudentProgress saveStudentProgress(StudentProgress studentProgress);

    Optional<StudentProgress> getStudentProgressById(Long id);

    List<StudentProgress> getAllStudentProgress();

    StudentProgress updateStudentProgress(Long id, StudentProgress studentProgress);

    void deleteStudentProgress(Long id);
}
