package com.library.implementations;

import com.library.entities.Categorie;
import com.library.interfaces.ICategorie;
import com.library.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieImpl implements ICategorie{

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save((categorie));
    }

    @Override
    public Optional<Categorie> findCategorie(int id) {
        return categorieRepository.findById(id);
    }

    @Override
    public void deleteCategorie(int id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public List<Categorie> findAllCategories() {
        return this.categorieRepository.findAll();
    }

}
