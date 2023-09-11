package com.example.projectmvccthymeleaf.controller;

import com.example.projectmvccthymeleaf.entities.Categorie;
import com.example.projectmvccthymeleaf.entities.Produit;
import com.example.projectmvccthymeleaf.repositories.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategoriesController {
    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping(path = "/cat")
    public String produits(Model model) {
        List<Categorie> categories = categoriesRepository.findAll();
        model.addAttribute("listCategories", categories);
        return "Categories.html";
    }
}