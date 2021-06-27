package one.digitalinnovation.animalAPI.controllers;

import one.digitalinnovation.animalAPI.dto.response.MessageResponseDTO;
import one.digitalinnovation.animalAPI.entity.Animal;
import one.digitalinnovation.animalAPI.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
// esse asterisco do "import org.springframework.web.bind.annotation.*;"
// inclui os: .PostMapping, .RequestBody, .RequestMapping, .RestController

@RestController
@RequestMapping("/api/v1/animals") //caminho de acesso principal da api
public class AnimalController {

private AnimalService animalService;


        @Autowired
        public AnimalController(AnimalService animalService){
            this.animalService = animalService;

        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAnimal(@RequestBody Animal animal) {//passado durante a requisição
        return animalService.createAnimal(animal);
    }



}



