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
    private Long remainingQty;
    private Long outputQty;


    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    public Stock(Long id, Long totalQty, Product product) {
        this.id = id;
        this.registrationDate = Instant.now();
        this.totalQty = totalQty;
        this.product = product;
    }

}
