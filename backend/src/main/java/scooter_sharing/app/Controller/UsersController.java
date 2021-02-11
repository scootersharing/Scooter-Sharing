package scooter_sharing.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import scooter_sharing.app.Entities.UserEntities;
import scooter_sharing.app.Repository.UsersRepository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<UserEntities> retrieveAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public List<UserEntities> retrieveUser(@PathVariable long id) {
        return usersRepository.findAllById(Collections.singleton(id));
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
