import com.example.erpproduit.Entity.Produit;
import com.example.erpproduit.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Création d'un produit avec @ModelAttribute pour les formulaires Thymeleaf
    @PostMapping("/add")
    public String CreeProduit(@ModelAttribute("produit") Produit produit) {
        produitService.CreerProoduit(produit);
        return "redirect:/produits/all"; // Redirection vers la liste après création
    }

    // Affichage de tous les produits
    @GetMapping("/all")
    public String AfficheTousProduits(Model model) {
        List<Produit> produits = produitService.ALLPR();
        model.addAttribute("produits", produits);
        System.out.println(produits);
        return "index"; // Nom de la page pour la liste des produits
    }

    // Affichage des détails d'un produit par ID
    @GetMapping("/{id}")
    public String ProduitParId(@PathVariable Long id, Model model) {
        Produit produit = produitService.GetOnePR(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        model.addAttribute("produit", produit);
        return "produit"; // Nom de la page pour afficher les détails du produit
    }

    // Suppression d'un produit par ID
    @DeleteMapping("/del/{id}")
    public String SupprimerProduit(@PathVariable Long id) {
        produitService.deleteOnePR(id);
        return "redirect:/produits/all"; // Redirection vers la liste après suppression
    }
}
