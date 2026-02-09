package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.championnat.entities.Sponsor;
//param theni how type ta l id ta lentite sponsor
//PagingAndSortingRepository
//JpaRepository[batch]
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {



}
