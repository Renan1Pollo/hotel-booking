package com.renanpollo.bookingservice.core.domain.enums;

public enum BookingAction {

    PAY(1, "Pagamento confirmado"),
    FINISH(2, "Reserva finalizada após uso"),
    CANCEL(3, "Reserva cancelada antes do pagamento"),
    REFUND(4, "Reembolso realizado"),
    REOPEN(5, "Reserva reaberta após cancelamento");

    private final int code;
    private final String description;

    BookingAction(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
