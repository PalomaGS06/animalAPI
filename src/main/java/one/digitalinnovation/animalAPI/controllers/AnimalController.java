package one.digitalinnovation.animalAPI.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.animalAPI.dto.request.AnimalDTO;
import one.digitalinnovation.animalAPI.dto.response.MessageResponseDTO;
import one.digitalinnovation.animalAPI.entity.Animal;
import one.digitalinnovation.animalAPI.exception.AnimalNotFoundException;
import one.digitalinnovation.animalAPI.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
// esse asterisco do "import org.springframework.web.bind.annotation.*;"
// inclui os: .PostMapping, .RequestBody, .RequestMapping, .RestController, etc
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/animals")
//caminho de acesso principal da api
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class AnimalController {


private AnimalService animalService;

     //  @Autowired
     // public AnimalController(AnimalService animalService){
      //   this.animalService = animalService;

     // }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAnimal(@RequestBody @Valid AnimalDTO animalDTO) {//passado durante a requisição
        return animalService.createAnimal(animalDTO);
    }

    @GetMapping
    public List<AnimalDTO> listAll(){
           return animalService.listAll();
    }

    @GetMapping("/{id}")
    public AnimalDTO findById (@PathVariable Long id) throws AnimalNotFoundException { //indica que é uma requisição http
          return animalService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid AnimalDTO animalDTO) throws AnimalNotFoundException {
        return animalService.updateById(id, animalDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AnimalNotFoundException {
        animalService.delete(id);
    }

}



