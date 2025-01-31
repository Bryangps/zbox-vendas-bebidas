package com.zboxcross.bebida.entities.pk;

import com.zboxcross.bebida.entities.Order;
import com.zboxcross.bebida.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class OrderItemPk {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
