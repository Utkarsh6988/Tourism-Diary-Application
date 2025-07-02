package com.tourism.app.repository;

import com.tourism.app.model.DiaryEntry;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiaryRepository extends JpaRepository<DiaryEntry, Long> {
    List<DiaryEntry> findByUserId(Long userId);
}
