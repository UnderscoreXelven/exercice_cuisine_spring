package org.example.exercice4_cuisine.service;

import org.example.exercice4_cuisine.model.Categorie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategorieService implements BaseService<Categorie>{
    private Map<Integer, Categorie> categories;
    private int idCategorie;

    public CategorieService() {
        categories = new HashMap<>();
        idCategorie = 3;

        categories.put(1, Categorie.builder().nom("Pizza").id(1).build());
        categories.put(2, Categorie.builder().nom("Pasta").id(2).build());
        categories.put(3, Categorie.builder().nom("Boissons").id(3).build());
    }
    @Override
    public void delete(int id) {
        categories.remove(id);
    }

    @Override
    public Categorie get(int id) {
        return categories.get(id);
    }

    @Override
    public void add(Categorie categorie) {
        categorie.setId(++idCategorie);
        categories.put(categorie.getId(), categorie);
    }
    public void update(Categorie categorie) {
        categories.put(categorie.getId(), categorie);
    }

    @Override
    public List<Categorie> getAll() {
        return new ArrayList<>(categories.values());
    }
}
