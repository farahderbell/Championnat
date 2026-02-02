package tn.esprit.ds.championnat.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    private String emplacement;

    private LocalDate dateCourse;

    public Course() {
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public LocalDate getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(LocalDate dateCourse) {
        this.dateCourse = dateCourse;
    }
    // Many-to-Many vers Championnat
    @ManyToMany
    @JoinTable(
            name = "course_championnat",                  // table intermédiaire
            joinColumns = @JoinColumn(name = "course_id"),       // colonne qui référence Course
            inverseJoinColumns = @JoinColumn(name = "championnat_id") // colonne qui référence Championnat
    )
    private List<Championnat> championnats;

    @OneToMany(mappedBy = "course")
    private List<Position> positions;
}
