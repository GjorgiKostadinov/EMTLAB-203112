package com.example.emtlab2.web;

import com.example.emtlab2.model.enumerations.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @GetMapping
    public List<Category> allCategories(){
        return Arrays.stream(Category.values()).toList();
    }
}
