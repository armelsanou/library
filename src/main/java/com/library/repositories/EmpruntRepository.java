package com.library.repositories;

import com.library.entities.Emprunt;
import com.library.entities.EmpruntPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, EmpruntPK> {

}