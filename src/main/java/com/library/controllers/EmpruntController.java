package com.library.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.library.entities.Emprunt;
import com.library.implementations.EmpruntImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class EmpruntController {

    @Autowired
    EmpruntImpl empruntService;

    @PostMapping("/api/emprunt")
    public void emprunterLivre(@RequestBody ObjectNode objectNode) throws Exception{

        int isbn = Integer.parseInt(objectNode.get("isbn").asText());

        int idLecteur = Integer.parseInt(objectNode.get("idLecteur").asText());

        empruntService.emprunterLivre(isbn,idLecteur);
    }

    @RequestMapping(value = "/api/emprunts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Emprunt> getAllEmprunts() {
        return empruntService.findAll();
    }

    @PatchMapping("/api/emprunt/avertir")
    public void avertirLecteur(@RequestBody ObjectNode objectNode) throws Exception{

        System.out.println("given"+ objectNode);
        int isbn = Integer.parseInt(objectNode.get("isbn").asText());

        int idLecteur = Integer.parseInt(objectNode.get("idLecteur").asText());

        String dateEmprunt = String.valueOf((objectNode.get("dateEmprunt").asText()));

        Date empruntDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateEmprunt);

        empruntService.avertirLecteur(isbn,idLecteur,empruntDate);
    }
}