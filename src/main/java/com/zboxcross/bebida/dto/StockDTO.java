package com.zboxcross.bebida.dto;

import com.zboxcross.bebida.entities.Stock;

import java.time.Instant;

public class StockDTO {

    private Long id;
    private Instant registrationDate;
    private Long totalQty;
    private Long outputQty;

    public StockDTO() {
    }

    public StockDTO(Stock entity) {
        id = entity.getId();
        registrationDate = entity.getRegistrationDate();
        totalQty = entity.getTotalQty();
        outputQty = entity.getOutputQty();
    }

    public Long getId() {
        return id;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public Long getTotalQty() {
        return totalQty;
    }

    public Long getOutputQty() {
        return outputQty;
    }
}
