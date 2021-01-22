package scooter_sharing.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import scooter_sharing.app.Entities.Users;
import scooter_sharing.app.Repository.UsersRepository;

import java.util.List;

public class UsersServices {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> list() {
        return usersRepository.findAll();
    }
}
