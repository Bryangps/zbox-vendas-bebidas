package com.zboxcross.bebida.dto;


import com.zboxcross.bebida.entities.Product;
import jakarta.validation.constraints.*;

public class ProductDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisar ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requirido")
    private String name;
    private String imgUrl;
    @NotNull(message = "Campo requirido")
    @Positive(message = "O preço deve ser positivo")
    private Double price;
    @NotBlank(message = "Campo requirido")
    private String ml;
    @NotNull(message = "Campo requirido")
    private CategoryDTO category;
    @NotNull(message = "Campo requirido")
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
