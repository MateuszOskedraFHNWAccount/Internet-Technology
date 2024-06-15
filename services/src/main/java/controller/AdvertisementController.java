package services.src.main.java.controller;

import services.src.main.java.data.domain.Advertisement;
import services.src.main.java.data.repository.AdvertisementRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class AdvertisementController {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @PostMapping(path = "/api/admin/advertisements",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvertisement);
    }
    
}