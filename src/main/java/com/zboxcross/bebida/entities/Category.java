package com.zboxcross.bebida.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_category")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Exclude
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> product = new ArrayList<>();

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
