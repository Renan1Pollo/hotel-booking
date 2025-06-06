package com.renanpollo.bookingservice.core.domain.enums;

public enum BookingStatus {

    CREATED_NOT_PAID(1, "Criado (Não pago)"),
    PAID(2, "Pago"),
    FINISHED(3, "Finalizado (após período)"),
    CANCELLED(4, "Cancelado (pagamento falhou ou cancelamento manual)"),
    REFUNDED(5, "Reembolsado");

    private final int code;
    private final String description;

    BookingStatus(int code, String description) {
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
