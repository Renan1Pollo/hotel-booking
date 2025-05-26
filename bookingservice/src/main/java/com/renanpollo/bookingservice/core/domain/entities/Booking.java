package com.renanpollo.bookingservice.core.domain.entities;

import java.time.LocalDateTime;

public class Booking {

    private Long id;
    private LocalDateTime placedAt;
    private LocalDateTime start;
    private LocalDateTime end;
    private int statusCode;

    public Booking() {
    }

    public Booking(Long id, LocalDateTime placedAt, LocalDateTime start, LocalDateTime end, int statusCode) {
        this.id = id;
        this.placedAt = placedAt;
        this.start = start;
        this.end = end;
        this.statusCode = statusCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
