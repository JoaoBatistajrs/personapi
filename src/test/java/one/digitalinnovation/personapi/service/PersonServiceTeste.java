package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTeste {

    @Mock
    private Repository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testeGivenPersonDTOTheReturnSavedMessage(){
        PersonDTO PersonDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccesMessage = createdExpectedMessageResponse(expectedSavedPerson.getId());

        MessageResponseDTO succesMessage = personService.createperson(PersonDTO);

        Assertions.assertEquals(expectedSuccesMessage, succesMessage);
    }

    private MessageResponseDTO createdExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
