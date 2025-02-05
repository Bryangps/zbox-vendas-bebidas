package com.zboxcross.bebida.services;

import com.zboxcross.bebida.dto.ProductDTO;
import com.zboxcross.bebida.dto.ProductMinDTO;
import com.zboxcross.bebida.entities.Category;
import com.zboxcross.bebida.entities.Product;
import com.zboxcross.bebida.entities.Stock;
import com.zboxcross.bebida.repositories.ProductRepository;
import com.zboxcross.bebida.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private StockRepository stockRepository;

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


    @Transactional
    public ProductDTO insert(ProductDTO dto){

        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        stockRepository.save(entity.getStock());
        return new ProductDTO(entity);
    }


    private void copyDtoToEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPrice(dto.getPrice());
        entity.setMl(dto.getMl());

        Category category = new Category();
        category.setId(dto.getCategory().getId());
        entity.setCategory(category);

        Stock stock = new Stock();
        stock.setTotalQty(dto.getStock().getTotalQty());
        stock.setRegistrationDate(Instant.now());
        stock.setOutputQty(0L);
        stock.setProduct(entity);
        entity.setStock(stock);
    }
}
