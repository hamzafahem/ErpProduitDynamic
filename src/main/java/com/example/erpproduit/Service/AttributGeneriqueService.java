package com.example.erpproduit.Service;

import com.example.erpproduit.Controller.AttributGeneriqueController;
import com.example.erpproduit.Entity.AttributGenerique;
import com.example.erpproduit.Repository.AttributGeneriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributGeneriqueService {
    @Autowired
    private AttributGeneriqueRepository attributGeneriqueRepository;

    public AttributGenerique creerAttribut(AttributGenerique attributGenerique){
        return attributGeneriqueRepository.save(attributGenerique);
    }
    public List<AttributGenerique> allAttribut(){
        return attributGeneriqueRepository.findAll();
    }
    public Optional<AttributGenerique> getOneAttribut(Long id) {
        Optional<AttributGenerique> attribut = attributGeneriqueRepository.findById(id);

        if (attribut.isPresent()) {
            System.out.println("L'attribut a été trouvé");
        } else {
            System.out.println("Cet attribut n'existe pas");
        }

        return attribut;
    }
    public String deleteAttribut(Long id) {
        Optional<AttributGenerique> optionalAttG = attributGeneriqueRepository.findById(id);

        if (optionalAttG.isPresent()) {
            AttributGenerique attribut = optionalAttG.get();
            attributGeneriqueRepository.deleteById(id);
            return "L'attribut " + attribut.getNom() + " a été supprimé avec succès.";
        } else {
            return "Cet attribut n'existe pas.";
        }
    }

}
