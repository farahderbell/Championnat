package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.championnat.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {


}
