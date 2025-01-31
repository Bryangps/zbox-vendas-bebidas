package com.zboxcross.bebida.entities;

import com.zboxcross.bebida.entities.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "tb_payment")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer paymentMethod;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant paymentDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "order_id")
    private Order order;

    public Payment(Long id, PaymentMethod paymentMethod, Instant paymentDate, Order order) {
        this.id = id;
        setPaymentMethod(paymentMethod);
        this.paymentDate = paymentDate;
        this.order = order;
    }

    public PaymentMethod getPaymentMethod(){
        return PaymentMethod.valueOf(paymentMethod);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod.getCode();
    }
}
