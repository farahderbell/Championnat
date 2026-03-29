package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.ChampionnatApplication;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.DetailChampionnat;
import tn.esprit.ds.championnat.entities.Equipe;

import java.util.List;

public interface IChampionnatService {

    Championnat addChampionnatEtDetails(Championnat c);
    Championnat affecterDetailsToChampionnat(DetailChampionnat detail , Long idChampionnat);
    String affecterCourseToChampionnat(Long idCourse, Long idChampionnat);

    List<Championnat> listChampionnat();
}
