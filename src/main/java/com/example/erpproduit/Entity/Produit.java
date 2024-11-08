package com.example.erpproduit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private Double prix;
//laserialisation asat 9labe  3liha kanet ci haja cascade all 3tatni error 500 o mnin redetha Fetch EAger..
    @OneToMany(mappedBy = "produit", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ValeurAttribut> valeursAttributs = new ArrayList<>();
}
