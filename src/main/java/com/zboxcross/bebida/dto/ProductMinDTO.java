package com.zboxcross.bebida.dto;

import com.zboxcross.bebida.entities.Product;

public class ProductMinDTO {

    private Long id;
    private String name;
    private String imgUrl;
    private Double price;
    private String ml;

    public ProductMinDTO() {
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        imgUrl = entity.getImgUrl();
        price = entity.getPrice();
        ml = entity.getMl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public String getMl() {
        return ml;
    }
}
