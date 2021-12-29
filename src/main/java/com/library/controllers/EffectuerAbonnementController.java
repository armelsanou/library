package com.library.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.library.entities.Effectuerabonnement;
import com.library.implementations.EffectuerAbonnementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EffectuerAbonnementController {

    @Autowired
    EffectuerAbonnementImpl effectuerAbonnementService;

    @PostMapping("/api/effectuer-abonnement")
    public void sAbonner(@RequestBody ObjectNode objectNode) throws Exception{

        int idAbonnement = Integer.parseInt(objectNode.get("idAbonnement").asText());

        int idLecteur = Integer.parseInt(objectNode.get("idLecteur").asText());

        effectuerAbonnementService.sAbonner(idAbonnement,idLecteur);
    }

    @GetMapping("/api/abonnements-effectues")
    public List<Effectuerabonnement> abonnementsEffectues() throws Exception{
        return effectuerAbonnementService.findAll();
    }
}