package com.Metafp.CiudadAlDia.service;
import com.Metafp.CiudadAlDia.dto.CategoriesDto;
public interface CategoryService {
    CategoriesDto save(CategoriesDto categoriesDto);
    CategoriesDto findById(int id);
    void delete(int id);

}
