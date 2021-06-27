package one.digitalinnovation.animalAPI.service;
import lombok.AllArgsConstructor;
import one.digitalinnovation.animalAPI.dto.request.AnimalDTO;
import one.digitalinnovation.animalAPI.dto.response.MessageResponseDTO;
import one.digitalinnovation.animalAPI.entity.Animal;
import one.digitalinnovation.animalAPI.exception.AnimalNotFoundException;
import one.digitalinnovation.animalAPI.mapper.AnimalMapper;
import one.digitalinnovation.animalAPI.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class AnimalService {

    private AnimalRepository animalRepository;

    private final AnimalMapper animalMapper = AnimalMapper.INSTANCE;

    public MessageResponseDTO createAnimal(AnimalDTO animalDTO) { //passado durante a requisição
        Animal animalToSave = animalMapper.toModel(animalDTO);

        Animal savedAnimal = animalRepository.save(animalToSave);
        return createMessageResponse(savedAnimal.getId(), "Created animal with ID ");
    }


    public List<AnimalDTO> listAll() {
        List<Animal> allAnimal = animalRepository.findAll(); //lista todo mundo
        return allAnimal.stream() //transformações de dados em coleções
                .map(animalMapper::toDTO)
                .collect(Collectors.toList());

    }

    public AnimalDTO findById(Long id) throws AnimalNotFoundException {
       // Optional<Animal> optionalAnimal = animalRepository.findById(id);
        //if (optionalAnimal.isEmpty())
        //    throw new AnimalNotFoundException(id);
       // return animalMapper.toDTO(optionalAnimal.get());
              Animal animal = verifyIfExists(id);
        return animalMapper.toDTO(animal); // indica quando um animal está presente ou não
    }

    public MessageResponseDTO updateById(Long id, AnimalDTO animalDTO) throws AnimalNotFoundException {
        verifyIfExists(id);

        Animal animalToUpdate = animalMapper.toModel(animalDTO);

       Animal updatedAnimal= animalRepository.save(animalToUpdate);
        return createMessageResponse(updatedAnimal.getId(), "Updated animal with ID ");
    }

    public void delete(Long id) throws AnimalNotFoundException {
        verifyIfExists(id);
        animalRepository.deleteById(id);
    }

    private Animal verifyIfExists(Long id) throws AnimalNotFoundException {
        return animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();

    }

}