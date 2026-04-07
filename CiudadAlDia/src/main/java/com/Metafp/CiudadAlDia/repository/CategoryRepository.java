package com.Metafp.CiudadAlDia.repository;

import com.Metafp.CiudadAlDia.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,Integer> {
}
