package org.example.exercice4_cuisine.service;

import org.example.exercice4_cuisine.model.Categorie;
import org.example.exercice4_cuisine.model.Recette;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecetteService implements BaseService<Recette>{
    private Map<Integer, Recette> recettes;
    private int idRecette;

    public RecetteService() {
        recettes = new HashMap<>();
        idRecette = 1;

        recettes.put(1, Recette.builder().nom("Soupe").id(1).categorie(Categorie.builder().nom("Pizza").build()).build());
    }

    public void add(Recette recette) {
        recettes.put(++idRecette, recette);
    }

    public void delete(int id) {
        recettes.remove(id);
    }

    public void update(Recette recette) {
        recettes.put(recette.getId(), recette);
    }

    public List<Recette> getAll() {
        return new ArrayList<>(recettes.values());
    }

    public Recette get(int id) {
        return recettes.get(id);
    }
}
