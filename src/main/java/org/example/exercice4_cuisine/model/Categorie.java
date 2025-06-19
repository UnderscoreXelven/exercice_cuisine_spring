package org.example.exercice4_cuisine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categorie {
    private Integer id;
    private String nom;
    private String description;
}
