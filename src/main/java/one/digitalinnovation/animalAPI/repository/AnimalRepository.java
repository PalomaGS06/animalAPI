package one.digitalinnovation.animalAPI.repository;

import one.digitalinnovation.animalAPI.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
