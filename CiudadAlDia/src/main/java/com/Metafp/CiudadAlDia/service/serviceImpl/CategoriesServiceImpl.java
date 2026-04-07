package com.Metafp.CiudadAlDia.service.serviceImpl;

import com.Metafp.CiudadAlDia.dto.CategoriesDto;
import com.Metafp.CiudadAlDia.entity.Categories;
import com.Metafp.CiudadAlDia.exception.ResourceNotFoundException;
import com.Metafp.CiudadAlDia.mapper.CategoriesTransformer;
import com.Metafp.CiudadAlDia.repository.CategoryRepository;
import com.Metafp.CiudadAlDia.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoryService {
   private final CategoryRepository categoryRepository;
private final CategoriesTransformer categoriesTransformer;
    public CategoriesServiceImpl(CategoryRepository categoryRepository, CategoriesTransformer categoriesTransformer) {
        this.categoryRepository = categoryRepository;
        this.categoriesTransformer = categoriesTransformer;
    }


    @Override
    public CategoriesDto save(CategoriesDto categoriesDto) {
        Categories entity = categoriesTransformer.toEntity(categoriesDto);
        Categories save = categoryRepository.save(entity);
        categoriesTransformer.toDto(save);
        return categoriesTransformer.toDto(save);
    }

    @Override
    public CategoriesDto findById(int id)
    {
        Categories categories = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category With This Id Is Not Found = "+id));
        return categoriesTransformer.toDto(categories);
    }

    @Override
    public void delete(int id) {
        Categories categories = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category With This Id Is Not Found = " + id));
        categoryRepository.deleteById(id);
    }
}
