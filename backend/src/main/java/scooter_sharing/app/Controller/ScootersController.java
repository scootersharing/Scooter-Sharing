package scooter_sharing.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scooter_sharing.app.Entities.ScooterEntities;
import scooter_sharing.app.Repository.ScootersRepository;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
public class ScootersController {
    @Autowired
    private ScootersRepository scootersRepository;

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML(){
        return "<html>\n" + "<head><title>Welcome to Scooter Sharing App</title></head>\n" +
                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
    }

    @GetMapping("/scooters")
    public List<ScooterEntities> retrieveAllScooters() {
        return scootersRepository.findAll();
    }

    @GetMapping("/scooters/{id}")
    public List<ScooterEntities> retrieveScooter(@PathVariable long id) {
        return scootersRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping("/scooters")
    public ResponseEntity<Object> createStudent(@RequestBody ScooterEntities scooterEntities) {
        ScooterEntities savedScooterEntities = scootersRepository.save(scooterEntities);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedScooterEntities.getScooter_ID()).toUri();

        return ResponseEntity.created(location).build();

    }
}
