package com.java.trackingNumberGenerator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRACKING", schema = "SESSION")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TRACKING_NUMBER", unique = true, nullable = false, length = 16)
    private String trackingNumber;

    @Column(name = "CREATED_AT", nullable = false)
    private String createdAt;

    public Tracking() {}

    public Tracking(String trackingNumber, String createdAt) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
    }

    public String getTrackingNumber() { return trackingNumber; }
    public String getCreatedAt() { return createdAt; }
}
