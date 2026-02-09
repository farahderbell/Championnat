package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.ds.championnat.entities.Pilote;

public interface PiloteRepository extends JpaRepository<Pilote,Long> {
}
