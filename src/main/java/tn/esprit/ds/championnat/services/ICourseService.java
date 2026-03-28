package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Course;
import tn.esprit.ds.championnat.entities.Position;

import java.util.List;

public interface ICourseService {


    Position ajouterCourse(Course course);

    List<Course> ajouterCourses(List<Course> courses);

    Course modifierCourse(Course course);

    void supprimerCourse (Long idCourse);

    List<Course> listCourses();

    Course recupererCourse(Long idCourse);
}
