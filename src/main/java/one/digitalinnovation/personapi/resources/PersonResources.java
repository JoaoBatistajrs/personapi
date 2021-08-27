package one.digitalinnovation.personapi.resources;


import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.personapi.domain.Person;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
public class PersonResources {

    private PersonService personService;

    @Autowired
    public PersonResources (PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ApiOperation(value = "Inclui uma nova pessoa no banco de dados")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson (@RequestBody Person person){
        return personService.createperson(person);
    }

}
