package com.renanpollo.bookingservice.core.domain.ports;

import com.renanpollo.bookingservice.core.domain.entities.Guest;

public interface IGuestRepository {
    Guest getGuestById(Long id);

    Guest createGuest(Guest user);
}
