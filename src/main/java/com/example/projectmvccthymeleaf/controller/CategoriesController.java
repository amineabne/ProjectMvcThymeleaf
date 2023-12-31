package com.example.projectmvccthymeleaf.controller;

import com.example.projectmvccthymeleaf.entities.Categorie;
import com.example.projectmvccthymeleaf.entities.Produit;
import com.example.projectmvccthymeleaf.repositories.CategoriesRepository;
import com.example.projectmvccthymeleaf.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class CategoriesController {
    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping(path = "/cat")
    public String produits(Model model , @RequestParam( name= "page" ,defaultValue="0") int page,
                           @RequestParam( name= "size" ,defaultValue="5")int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Categorie> pageCategories = categoriesRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listCategories", pageCategories.getContent());
        return "Categories.html";
    }
    public CategoriesController(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping("/deleteC")
    public  String delete(long id ) {

      categoriesRepository.deleteById((id) );
        return  "redirect:/index" ;
    }
    @GetMapping("h")
    public  String home( ) {

        return  "redirect:/index" ;
    }
    @GetMapping("/formCategories")
    public String formCategories(Model model){
        model.addAttribute("Categorie",new Categorie());
        return "formCategories";
    }
    @PostMapping("/saveC")
    public String save(Model model ,Categorie categorie){
        categoriesRepository.save(categorie);
        return "redirect:/index";
    }
}