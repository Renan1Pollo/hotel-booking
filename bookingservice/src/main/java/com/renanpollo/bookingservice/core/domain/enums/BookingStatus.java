package com.renanpollo.bookingservice.core.domain.enums;

import java.util.Arrays;

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

    public static BookingStatus fromCode(int code) {
        return Arrays.stream(values())
                .filter(status -> status.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código de status inválido: " + code));
    }

    public boolean isActive() {
        return this == CREATED_NOT_PAID || this == PAID;
    }

    public boolean isFinal() {
        return this == FINISHED || this == CANCELLED || this == REFUNDED;
    }

    public boolean canBeCancelled() {
        return this == CREATED_NOT_PAID || this == PAID;
    }
}
