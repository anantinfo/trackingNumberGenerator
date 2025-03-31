package com.java.trackingNumberGenerator.repository;

import com.java.trackingNumberGenerator.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    @Query("SELECT COUNT(t) > 0 FROM Tracking t WHERE t.trackingNumber = :trackingNumber")
    boolean existsByTrackingNumber(String trackingNumber);


    Tracking findByOriginCountryIdAndDestinationCountryIdAndWeightAndCreatedAtAndCustomerIdAndCustomerNameAndCustomerSlug(
            String originCountryId, String destinationCountryId, double weight, String createdAt, UUID customerId, String customerName, String customerSlug);
}