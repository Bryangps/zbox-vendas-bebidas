package com.zboxcross.bebida.controllers;

import com.zboxcross.bebida.dto.ProductDTO;
import com.zboxcross.bebida.dto.ProductMinDTO;
import com.zboxcross.bebida.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable){
        Page<ProductMinDTO> result = service.findAll(name, pageable);
        return ResponseEntity.ok(result);
    }
}
