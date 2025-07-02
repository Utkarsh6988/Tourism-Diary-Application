//package com.tourism.app.model;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//
//import jakarta.persistence.*;
//
//@Entity
//public class DiaryEntry {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;   // ✅ Add this field
//
//    private String content;
//    private String date;
//    
////    @Transient // Not stored in DB
////    public LocalDate getParsedDate() {
////        return LocalDate.parse(this.date); // Parse String → LocalDate
////    }
//
//    @ManyToOne
//    private User user;
//
//    // --- Getters and Setters ---
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {       // ✅ Add getter
//        return title;
//    }
//
//    public void setTitle(String title) {   // ✅ Add setter
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//    
//    public String getFormattedDate() {
//        try {
//            SimpleDateFormat fromDB = new SimpleDateFormat("yyyy-MM-dd");
//            SimpleDateFormat toDisplay = new SimpleDateFormat("dd MMM yyyy");
//            return toDisplay.format(fromDB.parse(this.date));
//        } catch (Exception e) {
//            return this.date; // Fallback to raw string if parsing fails
//        }
//    }
//}
package com.tourism.app.model;

import jakarta.persistence.*;

import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class DiaryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDate entryDate;
    private String imagePath;
    
    @ManyToOne
    private User user;

    @Transient
    private MultipartFile imageFile;

    // Constructors
    public DiaryEntry() {}

    public DiaryEntry(String title, String content, LocalDate entryDate) {
        this.title = title;
        this.content = content;
        this.entryDate = entryDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
    
    @Transient // This won't be persisted in the database
    public String getFormattedDate() {
        if (this.entryDate == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return this.entryDate.format(formatter);
    }
}