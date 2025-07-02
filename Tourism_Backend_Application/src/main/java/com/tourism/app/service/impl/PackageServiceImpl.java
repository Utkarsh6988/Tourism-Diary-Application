package com.tourism.app.service.impl;

import com.tourism.app.model.TourPackage;


import com.tourism.app.repository.TourPackageRepository;
import com.tourism.app.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {
    @Autowired private TourPackageRepository packageRepo;

    @Override
    public List<TourPackage> getAllPackages() {
        return packageRepo.findAll();
    }
    
    public TourPackage getPackageById(Long id) {
        return packageRepo.findById(id).orElse(null); // ✅ Safely returns null if not found
    }
}
