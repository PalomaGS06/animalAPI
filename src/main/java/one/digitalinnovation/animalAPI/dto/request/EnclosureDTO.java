package one.digitalinnovation.animalAPI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.animalAPI.enums.EnclosureType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnclosureDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private EnclosureType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}