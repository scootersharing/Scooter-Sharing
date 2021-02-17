package scooter_sharing.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scooter_sharing.app.Entities.ScooterEntities;
import scooter_sharing.app.Models.ScooterModel;
import scooter_sharing.app.Repository.ScootersRepository;

import java.net.URI;
import java.util.ArrayList;
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
    public List<ScooterModel> retrieveAllScooters() {
        List<ScooterModel> scooterModels = new ArrayList<>();
        for(ScooterEntities scooterEntities:scootersRepository.findAll()){
            ScooterModel scooterModel = new ScooterModel();
            scooterModel.setCharge(scooterEntities.getCharge());
            scooterModel.setIs_active(scooterEntities.isIs_active());
            scooterModel.setLatitude(scooterEntities.getLatitude());
            scooterModel.setLongitude(scooterEntities.getLongitude());
            scooterModels.add(scooterModel);
        }
        return scooterModels;
    }

    @GetMapping("/scooters/{id}")
    public List<ScooterModel> retrieveScooter(@PathVariable long id) {
        List<ScooterModel> scooterModels = new ArrayList<>();
        for(ScooterEntities scooterEntities:scootersRepository.findAllById(Collections.singleton(id))){
            ScooterModel scooterModel = new ScooterModel();
            scooterModel.setCharge(scooterEntities.getCharge());
            scooterModel.setIs_active(scooterEntities.isIs_active());
            scooterModel.setLatitude(scooterEntities.getLatitude());
            scooterModel.setLongitude(scooterEntities.getLongitude());
            scooterModels.add(scooterModel);
        }
        return scooterModels;
    }

    @PostMapping("/scooters/mass")
    public ResponseEntity<Object> massCreateStudent(@RequestBody List<ScooterEntities> scooterEntitiesList){
        try {
            scootersRepository.saveAll(scooterEntitiesList);
            return new ResponseEntity<>("Kullanıcılar başarı ile eklendi!", HttpStatus.OK);
        }
        catch (Exception e){

        }
        return new ResponseEntity<>("Hata oluştu", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/scooters")
    public ResponseEntity<Object> createStudent(@RequestBody ScooterEntities scooterEntities) {
        try {
            ScooterEntities savedScooterEntities = scootersRepository.save(scooterEntities);
            return new ResponseEntity<>("Kullanıcı başarı ile eklendi!", HttpStatus.OK);
        }
        catch (Exception e){

        }
        return new ResponseEntity<>("Hata oluştu", HttpStatus.BAD_REQUEST);
    }
}
