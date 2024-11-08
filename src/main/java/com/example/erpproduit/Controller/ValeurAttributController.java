package com.example.erpproduit.Controller;

import com.example.erpproduit.Entity.Produit;
import com.example.erpproduit.Entity.ValeurAttribut;
import com.example.erpproduit.Service.ProduitService;
import com.example.erpproduit.Service.ValeurAttributService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/Produits/{PRid}/attributs")
public class ValeurAttributController {
    @Autowired
    private ValeurAttributService valeurAttributService;
    @PostMapping("/{AttGid}")
      public ValeurAttribut AjouterValeurAttribut(@PathVariable Long PRid , @PathVariable Long AttGid, @RequestBody String valeur){
          return valeurAttributService.AjouterValeurAttribut(PRid, AttGid, valeur);
      }

}
