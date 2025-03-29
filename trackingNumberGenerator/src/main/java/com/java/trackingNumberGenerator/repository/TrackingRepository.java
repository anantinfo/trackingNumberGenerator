package com.java.trackingNumberGenerator.repository;

import com.java.trackingNumberGenerator.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    @Query("SELECT COUNT(t) > 0 FROM Tracking t WHERE t.trackingNumber = :trackingNumber")
    boolean existsByTrackingNumber(String trackingNumber);
}
