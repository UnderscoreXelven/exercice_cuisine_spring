package org.example.exercice4_cuisine.controller;

import jakarta.validation.Valid;
import org.example.exercice4_cuisine.model.Categorie;
import org.example.exercice4_cuisine.model.Recette;
import org.example.exercice4_cuisine.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategorieController {
    private CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/categorie/list")
    public String categorieList(Model model) {
        model.addAttribute("categories", categorieService.getAll());
        return "categorieMenu";
    }

    @GetMapping("/categorie/{id}")
    public String categorieDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("categorie", categorieService.get(id));
        return "categorieDetail";
    }

    @GetMapping("/categorie/add")
    public String categorieAdd(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "categorieAdd";
    }

    @PostMapping("/categorie/add")
    public String categorieAdd(@Valid @ModelAttribute("categorie") Categorie categorie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categorieAdd";
        }
        categorieService.add(categorie);
        return "redirect:/categorie/list";
    }

    @GetMapping("/categorie/edit/{id}")
    public String categorieEdit(@PathVariable("id") int id, Model model) {
        Categorie categorie = categorieService.get(id);
        model.addAttribute("categorie", categorie);
        return "categorieAdd";
    }

    @PostMapping("/categorie/update")
    public String categorieUpdate(@ModelAttribute("categorie") Categorie categorie) {
        categorieService.update(categorie);
        return "redirect:/categorie/list";
    }

    @GetMapping("/categorie/delete/{id}")
    public String categorieDelete(@PathVariable int id) {
        categorieService.delete(id);
        return "redirect:/categorie/list";
    }
}
