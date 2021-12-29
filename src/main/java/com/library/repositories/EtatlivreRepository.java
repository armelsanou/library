package com.library.repositories;

import com.library.entities.Etatlivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatlivreRepository extends JpaRepository<Etatlivre, Integer> {

}