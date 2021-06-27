package one.digitalinnovation.animalAPI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.br.CPF;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private Long id;

   @NotEmpty
    @CPF
    private String name;

   @NotEmpty
   @Size(min = 2, max = 100)
    private String sexo;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String especie;

    private String birthDate;

   @Valid
    @NotEmpty
    private List<EnclosureDTO> enclosures;
}