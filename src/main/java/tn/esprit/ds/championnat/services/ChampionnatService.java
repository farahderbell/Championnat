package tn.esprit.ds.championnat.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Course;
import tn.esprit.ds.championnat.entities.DetailChampionnat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;
import tn.esprit.ds.championnat.repositories.CourseRepository;
import tn.esprit.ds.championnat.repositories.DetailChampionnatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChampionnatService implements IChampionnatService{

    ChampionnatRepository championnatRepository;
    DetailChampionnatRepository detailChampionnatRepository;
    CourseRepository courseRepository;

    //ki nhotou CASCAD (nhotoha ala entite championnat) bech isir l ajout mta championnat o mah details mteou
    //maneha ahna bech namlou creation mte3 zouz fard wa9t
    //menghir l CASCAD raw bech ysir la jout ta championnat khw rodbelek farah!

    @Override
    public Championnat addChampionnatEtDetails(Championnat c) {
        return championnatRepository.save(c);
    }


    //kenna me7nech amlin cascad on nhebou nzidou details ll championnat mteou namlou haka
   //houni lezemna nkounou amlin setter ll details fel championnat
    @Override
    public Championnat affecterDetailsToChampionnat(DetailChampionnat detail, Long idChampionnat) {

        Championnat championnat = championnatRepository.findById(idChampionnat).get();

        championnat.setDetail(detail);
        championnatRepository.save(championnat);
        return championnat;

    }

    @Override
    public String affecterCourseToChampionnat(Long idCourse, Long idChampionnat) {
        Championnat championnat = championnatRepository.findById(idChampionnat).get();
        Course course = courseRepository.findById(idCourse).get();

        List<Course> coursesupdated = new ArrayList<>();
        if(championnat.getCourses()!=null){
            coursesupdated = championnat.getCourses();

        }
        coursesupdated.add(course);
        championnat.setCourses(coursesupdated);
        championnatRepository.save(championnat);

        return "added ! ";
    }


    @Override
    public  List<Championnat>  listChampionnat() {
        return championnatRepository.findAll();
    }


}

