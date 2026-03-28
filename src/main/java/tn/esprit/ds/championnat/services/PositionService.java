package tn.esprit.ds.championnat.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Position;
import tn.esprit.ds.championnat.repositories.PositionRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class PositionService implements IPositionService {

    private PositionRepository positionRepository;


    @Override
    public Position ajouterPosition(Position position) {
        position.setClassement(position.getClassement());
        position.setPilote(position.getPilote());
        position.setCourse(position.getCourse());
        position.setNbPoints(position.getNbPoints());
        return positionRepository.save(position);
    }

    @Override
    public List<Position> ajouterPositions(List<Position> positions) {
        List<Position
                > positionSauves = new ArrayList<>();

        for (Position
                s : positions) {



            Position
                    savedPosition
                    = positionRepository.save(s);
            positionSauves.add(savedPosition
            );
        }

        return positionSauves;
    }

    @Override
    public Position modifierPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public void supprimerPosition(Long idPosition) {
        if (positionRepository.existsById(idPosition)) {
            //kadin nabthou ken fel id mouch objet kemel
            //khir men findbyid
            positionRepository.deleteById(idPosition);
            System.out.println("Sponsor supprimé avec succès !");
        } else {
            System.out.println("Sponsor avec l'id " + idPosition + " n'existe pas.");
        }

    }

    @Override
    public List<Position> listPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position recupererPosition(Long idPosition) {
        if (positionRepository.existsById(idPosition)) {
            //.get ijib l objet
            return positionRepository.findById(idPosition).get();
        } else {
            System.out.println("Position avec l'id " + idPosition + " n'existe pas.");
            return null;
        }
    }
}
