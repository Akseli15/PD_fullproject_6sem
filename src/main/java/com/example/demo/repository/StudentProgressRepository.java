package com.example.demo.repository;

import com.example.demo.entity.StudentProgress;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {
    List<StudentProgress> findByUser(User user);
    Optional<StudentProgress> findByUserId(Long userId);
}
