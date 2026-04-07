package com.Metafp.CiudadAlDia.mapper;

import com.Metafp.CiudadAlDia.dto.CategoriesDto;
import com.Metafp.CiudadAlDia.entity.Categories;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoriesTransformer implements Transformer<Categories, CategoriesDto>{
    @Override
    public CategoriesDto toDto(Categories entity) {
        CategoriesDto categoriesDto = new CategoriesDto();
        categoriesDto.setNombreCategoria(entity.getNombreCategoria());
        return categoriesDto;
    }

    @Override
    public Categories toEntity(CategoriesDto dto) {
        Categories categories = new Categories();
        categories.setNombreCategoria(dto.getNombreCategoria());
        return categories;
    }

    @Override
    public List<CategoriesDto> toDtoList(List<Categories> user) {
        return List.of();
    }
}
