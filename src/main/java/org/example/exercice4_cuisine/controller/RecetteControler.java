package org.example.exercice4_cuisine.controller;

import org.example.exercice4_cuisine.model.Recette;
import org.example.exercice4_cuisine.service.CategorieService;
import org.example.exercice4_cuisine.service.RecetteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecetteControler {
    private RecetteService recetteService;
    private CategorieService categorieService;

    public RecetteControler(RecetteService recetteService, CategorieService categorieService) {
        this.recetteService = recetteService;
        this.categorieService = categorieService;
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/recette/list")
    public String recetteList(Model model) {
        model.addAttribute("recettes", recetteService.getAll());
        return "recetteMenu";
    }

    @GetMapping("/recette/add")
    public String recetteAdd(Model model) {
        model.addAttribute("recette", new Recette());
        model.addAttribute("categories", categorieService.getAll());
        return "recetteAdd";
    }

    @PostMapping("/recette/add")
    public String recetteAdd(@ModelAttribute("recette") Recette recette, @RequestParam("categorieId") int categorieId) {
        recette.setCategorie(categorieService.get(categorieId));
        recetteService.add(recette);
        return "redirect:/recette/list";
    }

    @GetMapping("/recette/{id}")
    public String recetteDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("recette", recetteService.get(id));
        return "recetteDetail";
    }

    @GetMapping("/recette/edit/{id}")
    public String recetteEdit(@PathVariable("id") int id, Model model) {
        Recette recette = recetteService.get(id);
        model.addAttribute("recette", recette);
        model.addAttribute("categories", categorieService.getAll());
        return "recetteAdd";
    }

    @PostMapping("/recette/update")
    public String recetteUpdate(@ModelAttribute("recette") Recette recette, @RequestParam("categorieId") int categorieId) {
        recette.setCategorie(categorieService.get(categorieId));
        recetteService.update(recette);
        return "redirect:/recette/list";
    }

    @GetMapping("/recette/delete/{id}")
    public String delete(@PathVariable int id) {
        recetteService.delete(id);
        return "redirect:/recette/list";
    }

}
