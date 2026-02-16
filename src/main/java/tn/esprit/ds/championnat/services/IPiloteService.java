package tn.esprit.ds.championnat.services;

import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Pilote;

@Repository

public interface IPiloteService {
    String addPilote (Pilote pilote);
}
