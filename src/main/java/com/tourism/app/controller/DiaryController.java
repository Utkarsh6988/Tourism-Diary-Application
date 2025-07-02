//package com.tourism.app.controller;
//
//import com.tourism.app.model.DiaryEntry;
//import com.tourism.app.service.DiaryService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@Controller
//@RequestMapping("/diary")  // Changed from /api/diary
//public class DiaryController {
//
//    @Autowired
//    private DiaryService diaryService;
//
//    // Thymeleaf endpoints
//    @GetMapping
//    public String showDiaryPage(Model model) {
//        model.addAttribute("diaryEntries", diaryService.getAllEntries());
//        model.addAttribute("diaryEntry", new DiaryEntry());
//        return "diary";
//    }
//
//    @PostMapping("/save")
//    public String saveEntry(@Valid @ModelAttribute("diaryEntry") DiaryEntry entry,
//                          BindingResult result,
//                          Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("diaryEntries", diaryService.getAllEntries());
//            return "diary";
//        }
//        diaryService.addEntry(entry);
//        return "redirect:/diary";
//    }
//
//    // REST API endpoints
//    @ResponseBody
//    @PostMapping("/api/add")
//    public DiaryEntry addEntry(@RequestBody DiaryEntry entry) {
//        return diaryService.addEntry(entry);
//    }
//
//    @ResponseBody
//    @GetMapping("/api/user/{userId}")
//    public List<DiaryEntry> getUserDiaries(@PathVariable Long userId) {
//        return diaryService.getEntriesByUserId(userId);
//    }
//
//    @ResponseBody
//    @PutMapping("/api/update/{id}")
//    public ResponseEntity<DiaryEntry> updateEntry(@PathVariable Long id, @RequestBody DiaryEntry entry) {
//        DiaryEntry updated = diaryService.updateEntry(id, entry);
//        return ResponseEntity.ok(updated);
//    }
//
//    @ResponseBody
//    @DeleteMapping("/api/delete/{id}")
//    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
//        diaryService.deleteEntry(id);
//        return ResponseEntity.noContent().build();
//    }
//}
package com.tourism.app.controller;

import com.tourism.app.model.DiaryEntry;
import com.tourism.app.service.DiaryService;
import com.tourism.app.util.FileUploadUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @Value("${upload.dir}")
    private String uploadDirectory;

    @GetMapping
    public String showDiaryPage(Model model) {
        model.addAttribute("diaryEntries", diaryService.getAllEntries());
        model.addAttribute("diaryEntry", new DiaryEntry());
        return "diary";
    }

    @PostMapping("/save")
    public String saveEntry(
            @Valid @ModelAttribute("diaryEntry") DiaryEntry entry,
            BindingResult result,
            @RequestParam(value = "image", required = false) MultipartFile imageFile, // Changed to "image" to match form
            RedirectAttributes redirectAttributes,
            Model model) throws IOException {
        
        if (result.hasErrors()) {
            model.addAttribute("diaryEntries", diaryService.getAllEntries());
            return "diary";
        }

        // Handle image upload only if file is present
        if (imageFile != null && !imageFile.isEmpty()) {
            String fileName = FileUploadUtil.saveFile(uploadDirectory, imageFile);
            entry.setImagePath(fileName);
        }

        diaryService.addEntry(entry);
        redirectAttributes.addFlashAttribute("success", "Entry saved successfully!");
        return "redirect:/diary";
    }

    // REST API endpoints remain the same
    @ResponseBody
    @PostMapping("/api/add")
    public DiaryEntry addEntry(@RequestBody DiaryEntry entry) {
        return diaryService.addEntry(entry);
    }

    @ResponseBody
    @GetMapping("/api/user/{userId}")
    public List<DiaryEntry> getUserDiaries(@PathVariable Long userId) {
        return diaryService.getEntriesByUserId(userId);
    }

    @ResponseBody
    @PutMapping("/api/update/{id}")
    public ResponseEntity<DiaryEntry> updateEntry(@PathVariable Long id, @RequestBody DiaryEntry entry) {
        DiaryEntry updated = diaryService.updateEntry(id, entry);
        return ResponseEntity.ok(updated);
    }

    @ResponseBody
    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        diaryService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}