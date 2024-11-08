package com.example.erpproduit.Service;

import com.example.erpproduit.Entity.AttributGenerique;
import com.example.erpproduit.Entity.Produit;
import com.example.erpproduit.Entity.ValeurAttribut;
import com.example.erpproduit.Repository.AttributGeneriqueRepository;
import com.example.erpproduit.Repository.ProduitRepository;
import com.example.erpproduit.Repository.ValeurAttributRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValeurAttributService {
    @Autowired
    private ValeurAttributRepository valeurAttributRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private AttributGeneriqueRepository attributGeneriqueRepository;


    public ValeurAttribut AjouterValeurAttribut(Long produitId, Long attributId, String valeur){
        Produit PR = produitRepository.findAllById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        AttributGenerique AttG =attributGeneriqueRepository.findById(attributId)
                .orElseThrow(() -> new RuntimeException("Attribut non trouvé"));
         ValeurAttribut valeurAttribut = new ValeurAttribut();
         valeurAttribut.setProduit(PR);
         valeurAttribut.setAttribut(AttG);
         valeurAttribut.setValeur(valeur);
         return valeurAttributRepository.save(valeurAttribut);


    }


}
