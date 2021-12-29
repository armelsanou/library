package com.library.controllers;

import com.library.entities.Abonnement;
import com.library.implementations.AbonnementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AbonnementController {

    @Autowired
    AbonnementImpl abonnementService;

    @PostMapping("/api/abonnement")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement) throws Exception{
        return abonnementService.createAbonnement(abonnement);
    }

    @GetMapping("/api/abonnement/{id}")
    public Optional<Abonnement> getAbonnement(@PathVariable(value = "id") int id){
        return abonnementService.findAbonnement(id);
    }

    @PutMapping("/api/abonnement")
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) throws Exception{
        return abonnementService.updateAbonnement(abonnement);
    }

    @DeleteMapping("/api/abonnement/{id}")
    public void deleteAbonnement(@PathVariable(value = "id") int id){
        abonnementService.deleteAbonnement(id);
    }

    @RequestMapping(value = "/api/abonnements", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Abonnement> getAllAbonnements() {
        return abonnementService.findAllAbonnements();
    }
}