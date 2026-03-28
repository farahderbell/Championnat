package tn.esprit.ds.championnat.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Course;
import tn.esprit.ds.championnat.entities.Position;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService{
    @Override
    public Position ajouterCourse(Course course) {
        return null;
    }

    @Override
    public List<Course> ajouterCourses(List<Course> courses) {
        return List.of();
    }

    @Override
    public Course modifierCourse(Course course) {
        return null;
    }

    @Override
    public void supprimerCourse(Long idCourse) {

    }

    @Override
    public List<Course> listCourses() {
        return List.of();
    }

    @Override
    public Course recupererCourse(Long idCourse) {
        return null;
    }
}
