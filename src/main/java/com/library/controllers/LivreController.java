package com.library.controllers;

import com.library.entities.Livre;
import com.library.implementations.LivreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LivreController {

    @Autowired
    LivreImpl livreService;

    @PostMapping("/api/livre")
    public Livre addLivre(@RequestBody Livre livre) throws Exception{
        return livreService.createLivre(livre);
    }

    @GetMapping("/api/livre/{id}")
    public Optional<Livre> getLivre(@PathVariable(value = "id") int id){
        return livreService.findLivre(id);
    }

    @PutMapping("/api/livre")
    public Livre updateLivre(@RequestBody Livre livre) throws Exception{
        return livreService.updateLivre(livre);
    }

    @DeleteMapping("/api/livre/{id}")
    public void deleteLivre(@PathVariable(value = "id") int id){
        livreService.deleteLivre(id);
    }

    @RequestMapping(value = "/api/livres", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Livre> getAllLivres() {
        return livreService.findAllLivres();
    }

    @GetMapping("/api/livres/categorie/{id}")
    public List<Livre> findAllLivreByCategorie(@PathVariable(value = "id") int id){
        return livreService.findAllLivreByCategorie(id);
    }
}