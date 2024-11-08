package com.example.erpproduit.Controller;

import com.example.erpproduit.Entity.Produit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping("/hamza")
    public String accueil(Model model) {
        model.addAttribute("nom", "Hamza");
        return "produit-form";  // Correspond au template `index.html`
    }
    @GetMapping("/index")
    public String showIndex(Model model) {
        Produit produit = new Produit();
        produit.setNom("Nom du produit");
        model.addAttribute("produit", produit);
        return "index";
    }
}
