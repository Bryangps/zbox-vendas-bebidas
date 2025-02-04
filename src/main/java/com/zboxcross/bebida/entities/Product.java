package com.zboxcross.bebida.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tb_product")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    private String name;

    private String imgUrl;

    private Double price;

    private String ml;

    @OneToMany(mappedBy = "id.product")
    @Setter(AccessLevel.NONE)
    private Set<OrderItem> items = new HashSet<>();

    @ManyToOne
    private Category category;

    @OneToOne(mappedBy = "product")
    private Stock stock;

    public Product(Long id, String name, String imgUrl, Double price, String ml, Stock stock, Category category) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.ml = ml;
        this.stock = stock;
        this.category = category;
    }
}
