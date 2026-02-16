package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Pilote;


@Service
@AllArgsConstructor

public class PiloteService implements IPiloteService {
    @Override
    public String addPilote(Pilote pilote) {
        return "";
    }
}
