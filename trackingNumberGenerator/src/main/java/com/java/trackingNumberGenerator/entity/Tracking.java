package com.java.trackingNumberGenerator.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "TRACKING", schema = "SESSION", uniqueConstraints = @UniqueConstraint(columnNames = {"ORIGIN_COUNTRY_ID", "DESTINATION_COUNTRY_ID", "WEIGHT", "CREATED_AT", "CUSTOMER_ID", "CUSTOMER_NAME", "CUSTOMER_SLUG"}))
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TRACKING_NUMBER", unique = true, nullable = false, length = 16)
    private String trackingNumber;

    @Column(name = "ORIGIN_COUNTRY_ID", nullable = false)
    private String originCountryId;

    @Column(name = "DESTINATION_COUNTRY_ID", nullable = false)
    private String destinationCountryId;

    @Column(name = "WEIGHT", nullable = false)
    private double weight;

    @Column(name = "CREATED_AT", nullable = false)
    private String createdAt;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private UUID customerId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "CUSTOMER_SLUG", nullable = false)
    private String customerSlug;

    public Tracking() {}

    public Tracking(String trackingNumber, String originCountryId, String destinationCountryId, double weight, String createdAt, UUID customerId, String customerName, String customerSlug) {
        this.trackingNumber = trackingNumber;
        this.originCountryId = originCountryId;
        this.destinationCountryId = destinationCountryId;
        this.weight = weight;
        this.createdAt = createdAt;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSlug = customerSlug;
    }

    public String getTrackingNumber() { return trackingNumber; }
    public String getOriginCountryId() { return originCountryId; }
    public String getDestinationCountryId() { return destinationCountryId; }
    public double getWeight() { return weight; }
    public String getCreatedAt() { return createdAt; }
    public UUID getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getCustomerSlug() { return customerSlug; }
}