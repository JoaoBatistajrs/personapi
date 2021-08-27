package one.digitalinnovation.personapi.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonResources {

    @GetMapping
    public String getPerson(){
        return "Api Teste";
    }
}
