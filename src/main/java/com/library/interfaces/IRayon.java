package com.library.interfaces;

import com.library.entities.Rayon;
import java.util.List;
import java.util.Optional;

public interface IRayon {

    Rayon createRayon(Rayon rayon);

    Rayon updateRayon(Rayon rayon);

    void deleteRayon(int id);

    Optional<Rayon> findRayon(int id);

    List<Rayon> findAllRayons();

}
