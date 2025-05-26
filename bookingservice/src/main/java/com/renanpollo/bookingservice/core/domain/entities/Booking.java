package com.renanpollo.bookingservice.core.domain.entities;

import com.renanpollo.bookingservice.core.domain.enums.BookingAction;
import com.renanpollo.bookingservice.core.domain.enums.BookingStatus;

import java.time.LocalDateTime;

public class Booking {

    private Long id;
    private LocalDateTime placedAt;
    private LocalDateTime start;
    private LocalDateTime end;
    private Room room;
    private Guest guest;
    private BookingStatus status;

    public Booking() {
        this.status = BookingStatus.CREATED_NOT_PAID;
        this.placedAt = LocalDateTime.now();
    }

    public Booking(Long id, LocalDateTime placedAt, LocalDateTime start, LocalDateTime end, BookingStatus status) {
        this.id = id;
        this.placedAt = placedAt;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public void changeState(BookingAction action) {
        this.status = switch (this.status) {
            case CREATED_NOT_PAID -> switch (action) {
                case PAY    -> BookingStatus.PAID;
                case CANCEL -> BookingStatus.CANCELLED;
                default     -> this.status;
            };
            case PAID -> switch (action) {
                case FINISH  -> BookingStatus.FINISHED;
                case REFUND -> BookingStatus.REFUNDED;
                default      -> this.status;
            };
            case CANCELLED -> switch (action) {
                case REOPEN -> BookingStatus.CREATED_NOT_PAID;
                default     -> this.status;
            };
            default -> this.status;
        };
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

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
