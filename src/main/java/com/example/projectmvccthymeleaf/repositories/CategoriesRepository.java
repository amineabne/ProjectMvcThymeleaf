package com.example.projectmvccthymeleaf.repositories;

import com.example.projectmvccthymeleaf.entities.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categorie,Long> {
    Page<Categorie> findByNomContains(String kw , Pageable pageable) ;
}
