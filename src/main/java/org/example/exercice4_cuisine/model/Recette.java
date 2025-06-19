package org.example.exercice4_cuisine.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @NotBlank
    private String nom;

    @NotNull
    @NotBlank
    private String ingredients;

    @NotNull
    @NotBlank
    private String instructions;
    private Categorie categorie;
}
