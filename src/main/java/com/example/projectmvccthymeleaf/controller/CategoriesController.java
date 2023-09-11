package com.example.projectmvccthymeleaf.controller;

import com.example.projectmvccthymeleaf.entities.Categorie;
import com.example.projectmvccthymeleaf.entities.Produit;
import com.example.projectmvccthymeleaf.repositories.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategoriesController {
    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping(path = "/cat")
    public String produits(Model model , @RequestParam( name= "page" ,defaultValue="0") int page,
                           @RequestParam( name= "size" ,defaultValue="5")int size) {
        Page<Categorie> pageCategories = categoriesRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listCategories", pageCategories.getContent());
        return "Categories.html";
    }
}