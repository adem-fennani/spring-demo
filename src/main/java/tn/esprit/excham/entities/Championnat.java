package tn.esprit.excham.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Championnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChampionnat;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    @NonNull
    String libelleC;
    Integer annee;
    @ManyToMany( cascade = CascadeType.ALL)
    List<Course> courses;
    @OneToOne
    DetailChampionnat detailChampionnat;
    LocalDate date;













}
