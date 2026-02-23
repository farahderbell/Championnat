package tn.esprit.ds.championnat.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "detailchampionnat")


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailChampionnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idDetail;

     String code;

     String description;

    


    // Relation inverse
    @OneToOne(mappedBy = "detail")
    private Championnat championnat;
}
