package one.digitalinnovation.animalAPI.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.animalAPI.enums.EnclosureType;
import javax.persistence.*;


@Entity
@Data //insere getters e setters
@Builder // padrão de projeto para fazer a construção dos objetos
@AllArgsConstructor //insere construtores
@NoArgsConstructor

public class NumberEnclosure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // geração incremental
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnclosureType type;

    @Column(nullable = false)
    private String number;


}
