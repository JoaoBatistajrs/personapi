package one.digitalinnovation.personapi.controller;


import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController (PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ApiOperation(value = "Inclui uma nova pessoa no banco de dados")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson (@RequestBody @Valid PersonDTO personDTO){
        return personService.createperson(personDTO);
    }

    @GetMapping
    @ApiOperation(value = "Seleciona todos os registros de pessoas inseridos no banco de dados")
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);

    }
}
