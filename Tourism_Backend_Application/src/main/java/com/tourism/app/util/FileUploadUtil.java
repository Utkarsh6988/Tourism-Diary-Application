package com.tourism.app.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.util.StringUtils;
import java.util.Objects;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static String saveFile(String uploadDir, MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        // Normalize path to handle different OS formats
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        
        // Create directory with all parent directories if needed
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            System.out.println("Created upload directory at: " + uploadPath);
        }

        // Generate safe filename
        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = UUID.randomUUID() + fileExtension;

        // Save file with conflict resolution
        Path targetPath = uploadPath.resolve(uniqueFileName);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }

        return uniqueFileName;
    }
}