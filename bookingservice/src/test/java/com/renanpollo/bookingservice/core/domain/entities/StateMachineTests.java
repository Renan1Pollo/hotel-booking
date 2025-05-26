package com.renanpollo.bookingservice.core.domain.entities;

import com.renanpollo.bookingservice.core.domain.enums.BookingAction;
import com.renanpollo.bookingservice.core.domain.enums.BookingStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateMachineTests {

    private Booking booking;

    @BeforeEach
    void setUp() {
        booking = new Booking();
    }

    @Test
    void shouldAlwaysStartWithCreatedStatus() {
        assertEquals(BookingStatus.CREATED_NOT_PAID, booking.getStatus());
    }

    @Test
    void shouldSetStatusToPaidWhenPayingForABookingWithCreatedStatus() {
        booking.changeState(BookingAction.PAY);
        assertEquals(BookingStatus.PAID, booking.getStatus());
    }

    @Test
    void shouldSetStatusToCanceledWhenCancelingABookingWithCreatedStatus() {
        booking.changeState(BookingAction.CANCEL);
        assertEquals(BookingStatus.CANCELLED, booking.getStatus());
    }

    @Test
    void shouldSetStatusToFinishedWhenFinishingAPaidBooking() {
        booking.changeState(BookingAction.PAY);
        booking.changeState(BookingAction.FINISH);
        assertEquals(BookingStatus.FINISHED, booking.getStatus());
    }

    @Test
    void shouldSetStatusToRefoundedWhenRefoundingAPaidBooking() {
        booking.changeState(BookingAction.PAY);
        booking.changeState(BookingAction.REFUND);
        assertEquals(BookingStatus.REFUNDED, booking.getStatus());
    }

    @Test
    void shouldSetStatusToCreatedWhenReopeningACanceledBooking() {
        booking.changeState(BookingAction.CANCEL);
        booking.changeState(BookingAction.REOPEN);
        assertEquals(BookingStatus.CREATED_NOT_PAID, booking.getStatus());
    }

    @Test
    void shouldNotChangeStatusWhenRefoundingABookingWithCreatedStatus() {
        booking.changeState(BookingAction.REFUND);
        assertEquals(BookingStatus.CREATED_NOT_PAID, booking.getStatus());
    }

    @Test
    void shouldNotChangeStatusWhenRefoundingAFinishedBooking() {
        booking.changeState(BookingAction.PAY);
        booking.changeState(BookingAction.FINISH);
        booking.changeState(BookingAction.REFUND);
        assertEquals(BookingStatus.FINISHED, booking.getStatus());
    }
}
