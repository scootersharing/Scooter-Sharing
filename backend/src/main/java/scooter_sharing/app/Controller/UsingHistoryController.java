package scooter_sharing.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scooter_sharing.app.Entities.UsingHistoryEntities;
import scooter_sharing.app.Models.UsingHistoryModel;
import scooter_sharing.app.Repository.ScootersRepository;
import scooter_sharing.app.Repository.UsersRepository;
import scooter_sharing.app.Repository.UsingHistoryRepository;

import java.net.URI;
import java.util.ArrayList;
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
    public List<UsingHistoryModel> retrieveAllUsingHistory() {
        List<UsingHistoryModel> usingHistoryModels = new ArrayList<>();
        for (UsingHistoryEntities using:usingHistoryRepository.findAll()) {
            UsingHistoryModel usingHistoryModel = new UsingHistoryModel();
            usingHistoryModel.setEnd_latitude(using.getEnd_latitude());
            usingHistoryModel.setEnd_longitude(using.getEnd_longitude());
            usingHistoryModel.setEnd_timestamp(using.getEnd_timestamp());
            usingHistoryModel.setStart_latitude(using.getStart_latitude());
            usingHistoryModel.setStart_longitude(using.getStart_longitude());
            usingHistoryModel.setStart_timestamp(using.getStart_timestamp());
            usingHistoryModel.setUser_ID(using.getUsers().getUser_ID());
            usingHistoryModel.setScooter_ID(using.getScooters().getScooter_ID());
            usingHistoryModels.add(usingHistoryModel);
        }
        return usingHistoryModels;
    }
    @GetMapping("/usinghistory/{id}")
    public List<UsingHistoryModel> retrieveUsingHistory(@PathVariable long id) {
        List<UsingHistoryModel> usingHistoryModels = new ArrayList<>();
        for (UsingHistoryEntities using:usingHistoryRepository.findAllById(Collections.singleton(id))) {
            UsingHistoryModel usingHistoryModel = new UsingHistoryModel();
            usingHistoryModel.setEnd_latitude(using.getEnd_latitude());
            usingHistoryModel.setEnd_longitude(using.getEnd_longitude());
            usingHistoryModel.setEnd_timestamp(using.getEnd_timestamp());
            usingHistoryModel.setStart_latitude(using.getStart_latitude());
            usingHistoryModel.setStart_longitude(using.getStart_longitude());
            usingHistoryModel.setStart_timestamp(using.getStart_timestamp());
            usingHistoryModel.setUser_ID(using.getUsers().getUser_ID());
            usingHistoryModel.setScooter_ID(using.getScooters().getScooter_ID());
            usingHistoryModels.add(usingHistoryModel);
        }
        return usingHistoryModels;
    }
    @PostMapping("/usinghistory")
    public ResponseEntity<Object> addNewUsing(@RequestBody UsingHistoryModel usingHistoryModel) {
        UsingHistoryEntities savedUsingHistoryEntities = new UsingHistoryEntities();
        savedUsingHistoryEntities.setEnd_latitude(usingHistoryModel.getEnd_latitude());
        savedUsingHistoryEntities.setEnd_longitude(usingHistoryModel.getEnd_longitude());
        savedUsingHistoryEntities.setEnd_timestamp(usingHistoryModel.getEnd_timestamp());
        savedUsingHistoryEntities.setStart_timestamp(usingHistoryModel.getStart_timestamp());
        savedUsingHistoryEntities.setStart_latitude(usingHistoryModel.getStart_latitude());
        savedUsingHistoryEntities.setStart_longitude(usingHistoryModel.getStart_longitude());
        savedUsingHistoryEntities.setUsers(
                usersRepository.getOne(usingHistoryModel.getUser_ID())
        );
        savedUsingHistoryEntities.setScooters(
                scootersRepository.getOne(usingHistoryModel.getScooter_ID())
        );
        usingHistoryRepository.save(savedUsingHistoryEntities);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand("Basarılı bir sekilde kaydedildi").toUri();

        return ResponseEntity.created(location).build();

    }
}
