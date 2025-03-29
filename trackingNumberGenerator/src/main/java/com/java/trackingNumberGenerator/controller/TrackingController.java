package com.java.trackingNumberGenerator.controller;


import com.java.trackingNumberGenerator.entity.Tracking;
import com.java.trackingNumberGenerator.pojo.TrackingResponse;
import com.java.trackingNumberGenerator.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TrackingController {
    @Autowired
    private TrackingService trackingService;

    @PostMapping("/add-tracking-number")
    public ResponseEntity<?> addTrackingNumber(@RequestParam String trackingNumber) {
        trackingService.addTrackingNumber(trackingNumber);
        return ResponseEntity.ok("Tracking number added successfully.");
    }

    @GetMapping("/next-tracking-number")
    public ResponseEntity<?> getTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam double weight,
            @RequestParam String created_at,
            @RequestParam UUID customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

        String trackingNumber = trackingService.generateTrackingNumber();
        return ResponseEntity.ok(new TrackingResponse(trackingNumber, Instant.now().toString()));
    }

    @GetMapping("/all")
    public List<Tracking> getAllTrackingNumbers() {
        return trackingService.getAllTracking();
    }
}
