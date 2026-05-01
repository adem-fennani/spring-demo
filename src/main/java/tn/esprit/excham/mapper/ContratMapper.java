package tn.esprit.excham.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.esprit.excham.entities.Contrat;
import tn.esprit.excham.entities.ContratRequestDTO;
import tn.esprit.excham.entities.ContratResponseDTO;

@Mapper(componentModel = "spring")
public interface ContratMapper {

    ContratMapper INSTANCE = Mappers.getMapper(ContratMapper.class);

    Contrat toEntity(ContratRequestDTO dto);

    @Mapping(source = "equipe.libelleEq", target = "libelleEquipe")
    @Mapping(source = "sponsor.nom", target = "nomSponsor")
    ContratResponseDTO toDTO(Contrat contrat);
}

