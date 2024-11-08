package com.example.erpproduit.Service;

import com.example.erpproduit.Entity.Produit;
import com.example.erpproduit.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit CreerProoduit(Produit produit){
        return produitRepository.save(produit);

    }
    public List<Produit> ALLPR() {
        try {
            return produitRepository.findAll();
        } catch (Exception e) {
            // Enregistrez l'erreur pour le débogage
            System.err.println("Erreur lors de la récupération des produits : " + e.getMessage());
            throw e; // Vous pouvez lancer une exception personnalisée ici si besoin
        }
    }     public Optional<Produit> GetOnePR(Long id){

        return  produitRepository.findAllById(id);
     }
    public String deleteOnePR(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if (optionalProduit.isPresent()) {
            Produit produit = optionalProduit.get();
            produitRepository.deleteById(id);
            return "Le produit " + produit.getNom() + " est supprimé.";
        } else {
            return "Ce produit n'existe pas.";
        }
    }

}
