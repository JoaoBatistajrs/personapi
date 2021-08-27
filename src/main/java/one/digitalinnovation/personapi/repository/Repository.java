package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository <Person, Long> {
}
