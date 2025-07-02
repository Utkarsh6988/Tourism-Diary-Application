package com.tourism.app.service;

import com.tourism.app.model.TourPackage;
import java.util.List;

public interface PackageService {
    List<TourPackage> getAllPackages();

    TourPackage getPackageById(Long id); // ✅ Add this method
}