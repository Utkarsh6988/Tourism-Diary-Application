package com.utkarsh.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh.app.model.DiaryEntry;
import com.utkarsh.app.model.User;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {
    List<DiaryEntry> findByUser(User user);
    List<DiaryEntry> findByUserAndEntryDate(User user, LocalDate entryDate);
}