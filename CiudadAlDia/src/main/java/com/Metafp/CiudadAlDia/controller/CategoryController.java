package com.Metafp.CiudadAlDia.controller;

import com.Metafp.CiudadAlDia.dto.CategoriesDto;
import com.Metafp.CiudadAlDia.payload.ApiResponseMessage;
import com.Metafp.CiudadAlDia.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> save(@RequestBody CategoriesDto categoriesDto) {
        CategoriesDto save = categoryService.save(categoriesDto);

        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                .message("SuccessFully Created!")
                .status(HttpStatus.OK)
                .success(true)
                .data(save)
                .build();
      return   new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> findById(@PathVariable  int id){
        CategoriesDto byId = categoryService.findById(id);
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
         .message("SuccessFully Created!")
                .status(HttpStatus.OK)
                .success(true)
                .data(byId)
                .build();
        return   new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> delete(@PathVariable int id) {
        categoryService.delete(id);
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                .message("Category Deleted")
                .status(HttpStatus.OK)
                .success(true)
                .data(null)
                .build();
        return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }
}
