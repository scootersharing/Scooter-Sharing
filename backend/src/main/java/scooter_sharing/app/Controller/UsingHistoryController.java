package scooter_sharing.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scooter_sharing.app.Entities.UsingHistory;
import scooter_sharing.app.Entities.UsingHistoryModel;
import scooter_sharing.app.Repository.ScootersRepository;
import scooter_sharing.app.Repository.UsersRepository;
import scooter_sharing.app.Repository.UsingHistoryRepository;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
public class UsingHistoryController {
    @Autowired
    private UsingHistoryRepository usingHistoryRepository;
    @Autowired
    private ScootersRepository scootersRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/usinghistory")
    public List<UsingHistory> retrieveAllUsingHistory() {
        return usingHistoryRepository.findAll();
    }
    @GetMapping("/usinghistory/{id}")
    public List<UsingHistory> retrieveUsingHistory(@PathVariable long id) {
        return usingHistoryRepository.findAllById(Collections.singleton(id));
    }
    @PostMapping("/usinghistory")
    public ResponseEntity<Object> addNewUsing(@RequestBody UsingHistoryModel usingHistoryModel) {
        UsingHistory savedUsingHistory = new UsingHistory();
        savedUsingHistory.setEnd_latitude(usingHistoryModel.getEnd_latitude());
        savedUsingHistory.setEnd_longitude(usingHistoryModel.getEnd_longitude());
        savedUsingHistory.setEnd_timestamp(usingHistoryModel.getEnd_timestamp());
        savedUsingHistory.setStart_timestamp(usingHistoryModel.getStart_timestamp());
        savedUsingHistory.setStart_latitude(usingHistoryModel.getStart_latitude());
        savedUsingHistory.setStart_longitude(usingHistoryModel.getStart_longitude());
        savedUsingHistory.setUsers(
                usersRepository.getOne(usingHistoryModel.getUser_ID())
        );
        savedUsingHistory.setScooters(
                scootersRepository.getOne(usingHistoryModel.getScooter_ID())
        );
        usingHistoryRepository.save(savedUsingHistory);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand("Basarılı bir sekilde kaydedildi").toUri();

        return ResponseEntity.created(location).build();

    }
}
