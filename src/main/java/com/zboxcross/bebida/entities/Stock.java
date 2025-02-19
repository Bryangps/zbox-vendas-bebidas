package com.zboxcross.bebida.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_stock")
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'", timezone = "GMT")
    private Instant registrationDate;
    private Long totalQty;
    private Long outputQty;


    @OneToOne
    @MapsId
    private Product product;

    public Stock(Long id, Long totalQty, Product product, Long outputQty, Instant registrationDate) {
        this.id = id;
        this.totalQty = totalQty;
        this.product = product;
        this.outputQty = outputQty;
        this.registrationDate = registrationDate;
    }

}
