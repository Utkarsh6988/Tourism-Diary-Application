//package com.tourism.app.service.impl;
//
//import com.tourism.app.model.DiaryEntry;
//
//import com.tourism.app.repository.DiaryRepository;
//import com.tourism.app.service.DiaryService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DiaryServiceImpl implements DiaryService {
//
//    @Autowired
//    private DiaryRepository diaryRepository;
//
//    @Override
//    public DiaryEntry addEntry(DiaryEntry entry) {
//        return diaryRepository.save(entry);
//    }
//
//    @Override
//    public List<DiaryEntry> getEntriesByUserId(Long userId) {
//        return diaryRepository.findByUserId(userId);
//    }
//    @Override
//    public List<DiaryEntry> getAllEntries() {
//        return diaryRepository.findAll(); // Assuming you're using JPA
//    }
//
//    @Override
//    public DiaryEntry updateEntry(Long id, DiaryEntry updatedEntry) {
//        DiaryEntry existingEntry = diaryRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
//        existingEntry.setTitle(updatedEntry.getTitle());
//        existingEntry.setContent(updatedEntry.getContent());
//        existingEntry.setDate(updatedEntry.getDate());
//        return diaryRepository.save(existingEntry);
//    }
//
//    @Override
//    public void deleteEntry(Long id) {
//        if (!diaryRepository.existsById(id)) {
//            throw new RuntimeException("Entry not found with id: " + id);
//        }
//        diaryRepository.deleteById(id);
//    }
//}
package com.tourism.app.service.impl;

import com.tourism.app.model.DiaryEntry;
import com.tourism.app.repository.DiaryRepository;
import com.tourism.app.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    @Transactional
    public DiaryEntry addEntry(DiaryEntry entry) {
        // Set default date if not provided
        if (entry.getEntryDate() == null) {
            entry.setEntryDate(LocalDate.now());
        }
        return diaryRepository.save(entry);
    }

    @Override
    public List<DiaryEntry> getEntriesByUserId(Long userId) {
        return diaryRepository.findByUserId(userId);
    }

    @Override
    public List<DiaryEntry> getAllEntries() {
        return diaryRepository.findAll();
    }

    @Override
    @Transactional
    public DiaryEntry updateEntry(Long id, DiaryEntry updatedEntry) {
        return diaryRepository.findById(id)
                .map(existingEntry -> {
                    existingEntry.setTitle(updatedEntry.getTitle());
                    existingEntry.setContent(updatedEntry.getContent());
                    existingEntry.setEntryDate(updatedEntry.getEntryDate());
                    
                    // Only update image path if a new one was provided
                    if (updatedEntry.getImagePath() != null && !updatedEntry.getImagePath().isEmpty()) {
                        existingEntry.setImagePath(updatedEntry.getImagePath());
                    }
                    
                    return diaryRepository.save(existingEntry);
                })
                .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }

    @Override
    @Transactional
    public void deleteEntry(Long id) {
        DiaryEntry entry = diaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
        
        // Here you might want to add logic to delete the associated image file
        // FileUploadUtil.deleteFile(uploadDirectory, entry.getImagePath());
        
        diaryRepository.delete(entry);
    }

    @Override
    public DiaryEntry getEntryById(Long id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }
}