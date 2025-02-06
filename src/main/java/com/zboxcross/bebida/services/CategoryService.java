package com.zboxcross.bebida.services;

import com.zboxcross.bebida.dto.CategoryDTO;
import com.zboxcross.bebida.entities.Category;
import com.zboxcross.bebida.repositories.CategoryRepository;
import com.zboxcross.bebida.services.exceptions.DatabaseException;
import com.zboxcross.bebida.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {

        Category obj = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        return new CategoryDTO(obj);
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(String name, Pageable pageable) {

        Page<Category> categories = repository.searchByName(name, pageable);
        return categories.map( obj -> new CategoryDTO(obj));
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto){

        Category entity = new Category();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto){
        try {
            Category entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copyDtoToEntity(CategoryDTO dto, Category entity){
        entity.setName(dto.getName());
    }
}
