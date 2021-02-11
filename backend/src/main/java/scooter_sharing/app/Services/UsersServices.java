package scooter_sharing.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import scooter_sharing.app.Entities.UserEntities;
import scooter_sharing.app.Repository.UsersRepository;

import java.util.List;

public class UsersServices {
    @Autowired
    private UsersRepository usersRepository;

    public List<UserEntities> list() {
        return usersRepository.findAll();
    }
}
