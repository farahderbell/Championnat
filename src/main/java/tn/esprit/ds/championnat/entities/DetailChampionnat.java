package tn.esprit.ds.championnat.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // bech nhotou hethi bech metjinech l erreur INFINITE RECRUSION ki njarbou readChampionnat

    @JsonIgnore
    private Championnat championnat;
}
