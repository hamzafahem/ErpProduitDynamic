package com.example.erpproduit.Repository;

import com.example.erpproduit.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findAllById(Long id);
}
