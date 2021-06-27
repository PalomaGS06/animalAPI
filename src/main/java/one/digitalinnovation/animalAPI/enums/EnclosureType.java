package one.digitalinnovation.animalAPI.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum EnclosureType {

    ZOO("Zoo"),
    NUMBER("Number"),
    LOCAL("Local");


    private final String description;


}
