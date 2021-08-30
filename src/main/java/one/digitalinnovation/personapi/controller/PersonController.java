package one.digitalinnovation.personapi.controller;


import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins="*")
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ApiOperation(value = "Inclui uma nova pessoa no banco de dados")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson (@RequestBody @Valid PersonDTO personDTO){
        return personService.createperson(personDTO);
    }

    @GetMapping
    @ApiOperation(value = "Seleciona todos os registros de pessoas contidos no banco de dados")
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Seleciona através do ID um registro de pessoas, contido no banco de dados")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza através do ID um registro de pessoas, contido no banco de dados")
    public MessageResponseDTO updateById (@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deleta através do ID um registro de pessoas, contido no banco de dados")
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException  {
        personService.deleteById(id);
    }
}
