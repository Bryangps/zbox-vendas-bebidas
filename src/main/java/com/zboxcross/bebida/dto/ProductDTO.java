package com.zboxcross.bebida.dto;


import com.zboxcross.bebida.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String imgUrl;
    private Double price;
    private String ml;
    private CategoryDTO category;
    private StockDTO stock;

    public ProductDTO(){
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        imgUrl = entity.getImgUrl();
        price = entity.getPrice();
        ml = entity.getMl();
        category = new CategoryDTO(entity.getCategory());
        stock = new StockDTO(entity.getStock());
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

    public CategoryDTO getCategory() {
        return category;
    }

    public StockDTO getStock() {
        return stock;
    }
}
