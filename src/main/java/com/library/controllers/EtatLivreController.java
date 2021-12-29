package com.library.controllers;

import com.library.entities.Etatlivre;
import com.library.implementations.EtatLivreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class EtatLivreController {

    @Autowired
    EtatLivreImpl etatLivreService;

    @PostMapping("/api/etat-livre")
    public Etatlivre addEtatLivre(@RequestBody Etatlivre etatLivre) throws Exception{
        return etatLivreService.createEtatLivre(etatLivre);
    }

    @GetMapping("/api/etat-livre/{id}")
    public Optional<Etatlivre> getEtatLivre(@PathVariable(value = "id") int id){
        return etatLivreService.findEtatLivre(id);
    }


    @PutMapping("/api/etat-livre")
    public Etatlivre updateEtatLivre(@RequestBody Etatlivre etatLivre) throws Exception{
        return etatLivreService.updateEtatLivre(etatLivre);
    }

    @DeleteMapping("/api/etat-livre/{id}")
    public void deleteEtatLivre(@PathVariable(value = "id") int id){
        etatLivreService.deleteEtatLivre(id);
    }

    @RequestMapping(value = "/api/etat-livres", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Etatlivre> getAllEtatLivres() {
        return etatLivreService.findAllEtatLivres();
    }
}