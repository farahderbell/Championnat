package tn.esprit.ds.championnat.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "course")


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idCourse;

    String emplacement;

     LocalDate dateCourse;






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
