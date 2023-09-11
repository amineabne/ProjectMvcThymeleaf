package com.example.projectmvccthymeleaf.controller;

import com.example.projectmvccthymeleaf.entities.Produit;
import com.example.projectmvccthymeleaf.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProduitController {
    @Autowired
  private   ProduitRepository produitRepository;
    @GetMapping(path = "/index")
    public String produits (){
return "produit";
    }
}
