package one.digitalinnovation.animalAPI.mapper;


import one.digitalinnovation.animalAPI.dto.request.AnimalDTO;
import one.digitalinnovation.animalAPI.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalMapper {
    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);


    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Animal toModel(AnimalDTO animalDTO); //para conversão do DTO

    AnimalDTO toDTO(Animal animal);
}
