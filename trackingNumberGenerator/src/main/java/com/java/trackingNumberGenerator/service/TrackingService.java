package com.java.trackingNumberGenerator.service;

import com.java.trackingNumberGenerator.entity.Tracking;
import com.java.trackingNumberGenerator.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

@Service
public class TrackingService {
    private final TrackingRepository trackingRepository;
    private final ReentrantLock lock = new ReentrantLock();
    private static final Pattern TRACKING_PATTERN = Pattern.compile("^[A-Z0-9]{1,16}$");

    @Autowired
    public TrackingService(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    public String generateTrackingNumber() {
        lock.lock();
        try {
            String trackingNumber;
            do {
                trackingNumber = UUID.randomUUID().toString().replace("-", "").substring(0, 16).toUpperCase();
            } while (trackingRepository.existsByTrackingNumber(trackingNumber));

            Tracking tracking = new Tracking(trackingNumber, Instant.now().toString());
            trackingRepository.save(tracking);
            return trackingNumber;
        } finally {
            lock.unlock();
        }
    }

    public List<Tracking> getAllTracking() {
        return trackingRepository.findAll();
    }

    public void addTrackingNumber(String trackingNumber) {
        if (!TRACKING_PATTERN.matcher(trackingNumber).matches()) {
            throw new IllegalArgumentException("Tracking number must match the pattern: ^[A-Z0-9]{1,16}$");
        }
        if (!trackingRepository.existsByTrackingNumber(trackingNumber)) {
            trackingRepository.save(new Tracking(trackingNumber, Instant.now().toString()));
        } else {
            throw new IllegalArgumentException("Tracking number must be unique.");
        }
    }

}
