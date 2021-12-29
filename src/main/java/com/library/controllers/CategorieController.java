package com.library.controllers;

import com.library.entities.Categorie;
import com.library.implementations.CategorieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CategorieController {

    @Autowired
    CategorieImpl categorieService;

    @PostMapping("/api/categorie")
    public Categorie addCategorie(@RequestBody Categorie categorie) throws Exception{
        return categorieService.createCategorie(categorie);
    }

    @GetMapping("/api/categorie/{id}")
    public Optional<Categorie> getCategorie(@PathVariable(value = "id") int id){
        return categorieService.findCategorie(id);
    }

    @PutMapping("/api/categorie")
    public Categorie updateCategorie(@RequestBody Categorie categorie) throws Exception{
        return  categorieService.updateCategorie(categorie);
    }

    @DeleteMapping("/api/categorie/{id}")
    public void deleteCategorie(@PathVariable(value = "id") int id){
        categorieService.deleteCategorie(id);
    }

    @RequestMapping(value = "/api/categories", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Categorie> getAllCategories() {
        return categorieService.findAllCategories();
    }
}