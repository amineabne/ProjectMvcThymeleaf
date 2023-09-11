package com.example.projectmvccthymeleaf;

import com.example.projectmvccthymeleaf.entities.Produit;
import com.example.projectmvccthymeleaf.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class ProjectMvccThymeleafApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProjectMvccThymeleafApplication.class, args);


    }

    @Bean
    CommandLineRunner commandLineRunner(ProduitRepository produitRepository) {
        return args -> {
            produitRepository.save(new Produit(null, "amine", 22.2, null));
            produitRepository.save(new Produit(null, "ami", 33.0, null));
            produitRepository.findAll().forEach(produit -> System.out.println(produit.getNom()));
        };
    }
}