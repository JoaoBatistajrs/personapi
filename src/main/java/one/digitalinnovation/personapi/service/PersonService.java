package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.domain.Person;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private Repository personRepository;

    @Autowired
    public PersonService(Repository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createperson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();}
}
