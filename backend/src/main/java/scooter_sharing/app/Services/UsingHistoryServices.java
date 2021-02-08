package scooter_sharing.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import scooter_sharing.app.Entities.UsingHistory;
import scooter_sharing.app.Repository.UsingHistoryRepository;

import java.util.List;

public class UsingHistoryServices {
    @Autowired
    private UsingHistoryRepository usingHistoryRepository;
    public List<UsingHistory> list() {
        return usingHistoryRepository.findAll();
    }
}
