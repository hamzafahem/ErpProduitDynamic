package com.example.erpproduit.Controller;

import com.example.erpproduit.Entity.AttributGenerique;
import com.example.erpproduit.Service.AttributGeneriqueService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/AttG")
public class AttributGeneriqueController {
    @Autowired
    private AttributGeneriqueService attributGeneriqueService;
    @PostMapping("/add")
    public AttributGenerique creerAttribut(@RequestBody AttributGenerique attg) {
        return attributGeneriqueService.creerAttribut(attg);
    }
    @PostMapping("/all")
    public List<AttributGenerique> allAttG(){
        return attributGeneriqueService.allAttribut();
    }
    @GetMapping("/{id}")
    public Optional<AttributGenerique> GetOneAttG(@PathVariable Long id){
       return attributGeneriqueService.getOneAttribut(id) ;
    }
    @DeleteMapping("/del/{id}")
    public Void DeleteAttG(@PathVariable Long id){
        attributGeneriqueService.deleteAttribut(id);
        return null;
    }
}
