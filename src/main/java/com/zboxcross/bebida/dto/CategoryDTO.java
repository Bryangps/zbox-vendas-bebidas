package com.zboxcross.bebida.dto;

import com.zboxcross.bebida.entities.Category;

public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(){
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
