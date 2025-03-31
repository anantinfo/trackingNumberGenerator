package com.java.trackingNumberGenerator.service;

import com.java.trackingNumberGenerator.entity.Tracking;
import com.java.trackingNumberGenerator.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TrackingService {
    @Autowired
    private TrackingRepository trackingRepository;

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generateTrackingNumber() {
        return IntStream.range(0, 16)
                .mapToObj(i -> String.valueOf(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length()))))
                .collect(Collectors.joining());
    }

    public Tracking addTracking(String originCountryId, String destinationCountryId, double weight,
                                String createdAt, UUID customerId, String customerName, String customerSlug) {

        String trackingNumber = generateTrackingNumber();
        Tracking tracking = new Tracking(trackingNumber, originCountryId, destinationCountryId, weight, createdAt, customerId, customerName, customerSlug);
        return trackingRepository.save(tracking);
    }

    public Tracking getTrackingByDetails(String originCountryId, String destinationCountryId, double weight,
                                         String createdAt, UUID customerId, String customerName, String customerSlug) {
        return trackingRepository.findByOriginCountryIdAndDestinationCountryIdAndWeightAndCreatedAtAndCustomerIdAndCustomerNameAndCustomerSlug(
                originCountryId, destinationCountryId, weight, createdAt, customerId, customerName, customerSlug);
    }


    public List<Tracking> getAllTracking() {
        return trackingRepository.findAll();
    }

   /* public void addTrackingNumber(String trackingNumber) {
        try {
            if (!TRACKING_PATTERN.matcher(trackingNumber).matches()) {
                throw new IllegalArgumentException("Tracking number must match the pattern: ^[A-Z0-9]{1,16}$");
            }
            if (!trackingRepository.existsByTrackingNumber(trackingNumber)) {
                trackingRepository.save(new Tracking(trackingNumber, Instant.now().toString()));
            } else {
                throw new IllegalArgumentException("Tracking number must be unique.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error adding tracking number: " + e.getMessage(), e);
        }
    }*/


}
