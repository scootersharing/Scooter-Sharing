package scooter_sharing.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import scooter_sharing.app.Entities.UserEntities;
import scooter_sharing.app.Models.UserModel;
import scooter_sharing.app.Repository.UsersRepository;

import javax.validation.Valid;
import java.util.*;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<UserModel> retrieveAllUsers() {
        List<UserModel> userModels = new ArrayList<>();
        for(UserEntities userEntities:usersRepository.findAll()){
            UserModel userModel = new UserModel();
            userModel.setUsername(userEntities.getUsername());
            userModel.setBalance(userEntities.getBalance());
            userModel.setEmail(userEntities.getEmail());
            userModels.add(userModel);
        }
        return userModels;
    }

    @GetMapping("/users/{id}")
    public List<UserModel> retrieveUser(@PathVariable long id) {
        List<UserModel> userModels = new ArrayList<>();
        for(UserEntities userEntities:usersRepository.findAllById(Collections.singleton(id))){
            UserModel userModel = new UserModel();
            userModel.setUsername(userEntities.getUsername());
            userModel.setBalance(userEntities.getBalance());
            userModel.setEmail(userEntities.getEmail());
            userModels.add(userModel);
        }
        return userModels;
    }

    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody UserEntities userEntities) {
        usersRepository.save(userEntities);
        return ResponseEntity.ok("User is valid and saved.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
