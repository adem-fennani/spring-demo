package tn.esprit.excham.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailChampionnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDetailChampionnat;
    String description;
    String code;
   @OneToOne(mappedBy = "detailChampionnat")
    private Championnat championnat;

}
