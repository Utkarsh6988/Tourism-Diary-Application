package com.tourism.app.service;

import com.tourism.app.model.DiaryEntry;

import java.util.List;

public interface DiaryService {
    DiaryEntry addEntry(DiaryEntry entry);
    List<DiaryEntry> getEntriesByUserId(Long userId);
    List<DiaryEntry> getAllEntries();  // Add this new method
    DiaryEntry updateEntry(Long id, DiaryEntry updatedEntry);
    void deleteEntry(Long id);
    DiaryEntry getEntryById(Long id);  // Add this method
}
