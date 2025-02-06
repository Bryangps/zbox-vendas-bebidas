package com.zboxcross.bebida.services;

import com.zboxcross.bebida.dto.ProductDTO;
import com.zboxcross.bebida.dto.ProductMinDTO;
import com.zboxcross.bebida.entities.Category;
import com.zboxcross.bebida.entities.Product;
import com.zboxcross.bebida.entities.Stock;
import com.zboxcross.bebida.repositories.ProductRepository;
import com.zboxcross.bebida.repositories.StockRepository;
import com.zboxcross.bebida.services.exceptions.DatabaseException;
import com.zboxcross.bebida.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
        Product obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
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

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){

        Product entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        stockRepository.save(entity.getStock());
        return new ProductDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try{
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copyDtoToEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPrice(dto.getPrice());
        entity.setMl(dto.getMl());

        Category category = new Category();
        category.setId(dto.getCategory().getId());
        entity.setCategory(category);

        if (entity.getStock() == null) {
            Stock stock = new Stock();
            stock.setTotalQty(dto.getStock().getTotalQty());
            stock.setRegistrationDate(Instant.now());
            stock.setOutputQty(0L);
            stock.setProduct(entity);
            entity.setStock(stock);
        }
        else {
            Stock stock = stockRepository.getReferenceById(entity.getStock().getId());
            stock.setTotalQty(dto.getStock().getTotalQty());
            stock.setRegistrationDate(Instant.now());
            stock.setOutputQty(0L);
        }
    }
}
