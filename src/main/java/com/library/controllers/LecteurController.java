package com.library.controllers;

import com.library.entities.Lecteur;
import com.library.implementations.LecteurImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class LecteurController {

    @Autowired
    LecteurImpl lecteurService;

    @PostMapping("/login")
    public Lecteur findLecteur(@RequestBody Lecteur lecteur){
        System.out.println("para "+ lecteur);
        String login = "";
        if (lecteur.getEmail() != ""){
            login = lecteur.getEmail();
        }
        if (lecteur.getLogin() != ""){
            login = lecteur.getLogin();
        }
        return lecteurService.findLecteur(login, lecteur.getMdp());
    }

    @PostMapping("/lecteur")
    public Lecteur addLecteur(@RequestBody Lecteur lecteur) throws Exception{
        return lecteurService.createLecteur(lecteur);
    }

    @GetMapping("/lecteur/{id}")
    public Optional<Lecteur> getLecteur(@PathVariable(value = "id") int id){
        return lecteurService.findLecteur(id);
    }

    @PutMapping("/lecteur")
    public Lecteur updateLecteur(@RequestBody Lecteur Lecteur) throws Exception{
        return lecteurService.updateLecteur(Lecteur);
    }

    @DeleteMapping("/lecteur/{id}")
    public void deleteLecteur(@PathVariable(value = "id") int id){
        lecteurService.deleteLecteur(id);
    }

    @RequestMapping(value = "/lecteurs", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Lecteur> getAllLecteurs() {
        return lecteurService.findAllLecteurs();
    }
}