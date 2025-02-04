package com.zboxcross.bebida.services;

import com.zboxcross.bebida.dto.ProductDTO;
import com.zboxcross.bebida.dto.ProductMinDTO;
import com.zboxcross.bebida.entities.Product;
import com.zboxcross.bebida.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product obj = repository.findById(id).get();
        return new ProductDTO(obj);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable){
        Page<Product> products = repository.searchByName(name, pageable);
        return products.map(obj -> new ProductMinDTO(obj));
    }
}
