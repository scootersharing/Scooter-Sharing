package scooter_sharing.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scooter_sharing.app.Entities.Scooters;
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
    public List<Scooters> retrieveAllScooters() {
        return scootersRepository.findAll();
    }

    @GetMapping("/scooters/{id}")
    public List<Scooters> retrieveScooter(@PathVariable long id) {
        return scootersRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping("/scooters")
    public ResponseEntity<Object> createStudent(@RequestBody Scooters scooters) {
        Scooters savedScooters = scootersRepository.save(scooters);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedScooters.getScooter_ID()).toUri();

        return ResponseEntity.created(location).build();

    }
}
