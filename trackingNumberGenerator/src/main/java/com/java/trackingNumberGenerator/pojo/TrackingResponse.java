package com.java.trackingNumberGenerator.pojo;

public class TrackingResponse {
    private String trackingNumber;
    private String createdAt;

    public TrackingResponse(String trackingNumber, String createdAt) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
    }

    public String getTrackingNumber() { return trackingNumber; }
    public String getCreatedAt() { return createdAt; }
}