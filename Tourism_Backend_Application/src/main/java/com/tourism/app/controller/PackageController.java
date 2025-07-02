package com.tourism.app.controller;

import com.tourism.app.model.TourPackage;


import com.tourism.app.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/all")
    public List<TourPackage> getAllPackages() {
        return packageService.getAllPackages();
    }
}
