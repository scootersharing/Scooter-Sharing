package scooter_sharing.app.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scooter_sharing.app.Entities.Scooters;
import scooter_sharing.app.Repository.ScootersRepository;

import java.net.URI;
import java.util.List;

@RestController
public class ScootersResources {
    @Autowired
    private ScootersRepository scootersRepository;

    @GetMapping("/scooters")
    public List<Scooters> retrieveAllScooters() {
        return scootersRepository.findAll();
    }

    @PostMapping("/scooters")
    public ResponseEntity<Object> createStudent(@RequestBody Scooters scooters) {
        Scooters savedScooters = scootersRepository.save(scooters);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedScooters.getScooter_ID()).toUri();

        return ResponseEntity.created(location).build();

    }
}
