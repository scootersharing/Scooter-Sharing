package scooter_sharing.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import scooter_sharing.app.Entities.Scooters;
import scooter_sharing.app.Repository.ScootersRepository;

import java.util.List;

public class ScootersServices {
    @Autowired
    private ScootersRepository scootersRepository;

    public List<Scooters> list() {
        return scootersRepository.findAll();
    }
}
