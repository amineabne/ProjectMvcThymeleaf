package com.example.projectmvccthymeleaf.repositories;

import com.example.projectmvccthymeleaf.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository <Produit,Long> {

    Page<Produit> findByNomContains(String kw , Pageable pageable) ;
}
