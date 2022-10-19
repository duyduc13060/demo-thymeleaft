package com.example.demothymeleaft.controller;

import com.example.demothymeleaft.model.entity.CategoryEntity;
import com.example.demothymeleaft.model.entity.ProductEntity;
import com.example.demothymeleaft.repository.CategoryRepository;
import com.example.demothymeleaft.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RestController("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("categories")
    public List<CategoryEntity> getCategoryEntities(){
        return categoryRepository.findAll();
    }

    @GetMapping(value = "newOrEdit")
    public String newOrEdit(ModelMap model) {
        ProductEntity productEntity;
        productEntity = new ProductEntity();

        model.addAttribute("product", productEntity);

        return "";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(RedirectAttributes attributes,
                               ModelMap model,
                               ProductEntity productEntity
                               ) {
        productRepository.save(productEntity);
        model.addAttribute("product",productEntity);

        attributes.addAttribute("message", "New product is save!");

        return "redirect:/products";
    }


}
