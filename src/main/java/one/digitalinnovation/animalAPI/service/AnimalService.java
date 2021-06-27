package one.digitalinnovation.animalAPI.service;

import one.digitalinnovation.animalAPI.dto.request.AnimalDTO;
import one.digitalinnovation.animalAPI.dto.response.MessageResponseDTO;
import one.digitalinnovation.animalAPI.entity.Animal;
import one.digitalinnovation.animalAPI.mapper.AnimalMapper;
import one.digitalinnovation.animalAPI.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    private final AnimalMapper animalMapper = AnimalMapper.INSTANCE;

    @Autowired //junção de dependencias
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    public MessageResponseDTO createAnimal(AnimalDTO animalDTO) { //passado durante a requisição
        Animal animalToSave= animalMapper.toModel(animalDTO);

        Animal savedAnimal = animalRepository.save(animalToSave);
        return MessageResponseDTO
                .builder()
                .message("Created animal with ID " + savedAnimal.getId())
                .build();
    }





}
