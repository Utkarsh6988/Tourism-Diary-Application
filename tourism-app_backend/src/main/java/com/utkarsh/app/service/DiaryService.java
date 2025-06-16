package com.utkarsh.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utkarsh.app.dto.DiaryEntryDto;
import com.utkarsh.app.exception.ResourceNotFoundException;
import com.utkarsh.app.model.DiaryEntry;
import com.utkarsh.app.model.User;
import com.utkarsh.app.repository.DiaryEntryRepository;
import com.utkarsh.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryEntryRepository diaryEntryRepository = null;
    private final UserRepository userRepository = null;

    public DiaryEntry addDiaryEntry(DiaryEntryDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow();

        DiaryEntry entry = new DiaryEntry();
        entry.setUser(user);
        entry.setTitle(dto.getTitle());
        entry.setContent(dto.getContent());
        entry.setEntryDate(dto.getEntryDate());
        return diaryEntryRepository.save(entry);
    }

    public List<DiaryEntry> getUserDiaryEntries(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return diaryEntryRepository.findByUser(user);
    }
    
    public DiaryEntry getDiaryEntry(Long entryId) {
        return diaryEntryRepository.findById(entryId)
                .orElseThrow();
    }
}