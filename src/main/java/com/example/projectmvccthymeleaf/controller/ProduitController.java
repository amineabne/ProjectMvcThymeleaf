package com.example.projectmvccthymeleaf.controller;

import com.example.projectmvccthymeleaf.entities.Produit;
import com.example.projectmvccthymeleaf.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@ControllerAdvice
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(path = "/index")
    public String produits(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {


        Page<Produit> pageProduits=produitRepository.findByNomContains(keyword, PageRequest.of(page,size));

        model.addAttribute("listProduits",pageProduits.getContent());
        model.addAttribute("pages" , new int[pageProduits.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword" , keyword);
        return "produit.html";
    }
    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping("/delete")
    public  String delete(long id ) {
       produitRepository.deleteById((id) );
        return  "redirect:/index" ;
    }
    @GetMapping("/")
    public  String home( ) {

        return  "redirect:/index" ;
    }

    @GetMapping("/formProduits")
    public String formProduits(Model model){
        model.addAttribute("Produit",new Produit());
        return "formProduits";
    }

    @PostMapping("/save")
    public String save(Model model ,Produit produit){
      produitRepository.save(produit);
      return "redirect:/index";
    }
}
