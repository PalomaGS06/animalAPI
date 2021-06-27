package one.digitalinnovation.animalAPI.service;

import one.digitalinnovation.animalAPI.dto.response.MessageResponseDTO;
import one.digitalinnovation.animalAPI.entity.Animal;
import one.digitalinnovation.animalAPI.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    @Autowired //junção de dependencias
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    public MessageResponseDTO createAnimal(Animal animal) { //passado durante a requisição
        Animal savedAnimal = animalRepository.save(animal);
        return MessageResponseDTO
                .builder()
                .message("Created animal with ID " + savedAnimal.getId())
                .build();
    }





}
