package one.digitalinnovation.animalAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
    public class AnimalNotFoundException extends Exception {

        public AnimalNotFoundException(Long id){
              super("Animal not found with ID" + id);
        }

    }

