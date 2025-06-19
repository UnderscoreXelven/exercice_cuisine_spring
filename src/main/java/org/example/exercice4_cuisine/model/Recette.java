package org.example.exercice4_cuisine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recette {
    private Integer id;
    private String nom;
    private String ingredients;
    private String instructions;
    private Categorie categorie;
}
