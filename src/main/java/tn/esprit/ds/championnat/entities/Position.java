package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "position")


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


     Long idPosition;

     Integer classement;

    Integer nbPoints;






    @ManyToOne
    Course course;

    @ManyToOne
    Pilote pilote;

}
