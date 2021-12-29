package com.library.controllers;

import com.library.entities.Rayon;
import com.library.implementations.RayonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class RayonController {

    @Autowired
    RayonImpl rayonService;

    @PostMapping("/api/rayon")
    public Rayon addRayon(@RequestBody Rayon rayon) throws Exception{
        return rayonService.createRayon(rayon);
    }

    @GetMapping("/api/rayon/{id}")
    public Optional<Rayon> getRayon(@PathVariable(value = "id") int id){
        return rayonService.findRayon(id);
    }


    @PutMapping("/api/rayon")
    public Rayon updateRayon(@RequestBody Rayon rayon) throws Exception{
        return rayonService.updateRayon(rayon);
    }

    @DeleteMapping("/api/rayon/{id}")
    public void deleteRayon(@PathVariable(value = "id") int id){
        rayonService.deleteRayon(id);
    }

    @RequestMapping(value = "/api/rayons", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Rayon> getAllRayons() {
        return rayonService.findAllRayons();
    }
}