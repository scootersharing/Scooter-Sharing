package scooter_sharing.app.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserEntities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ID")
    private long user_ID;
    @Column(length = 43)
    @NotBlank(message = "Username field must not be blank")
    private String username;
    @Column(length = 32)
    @NotBlank(message = "Password field must not be blank")
    private String password;
    @Column(length = 64)
    @NotBlank(message = "Email field must not be blank")
    private String email;
    private double balance;
    @OneToMany(mappedBy="userEntities")
    private List<UsingHistoryEntities> usingHistoryEntities;
//    @OneToMany(mappedBy = "users")
//    Set<UsingHistoryEntities> usinghistories;
//
//    public Set<UsingHistoryEntities> getUsinghistories() {
//        return usinghistories;
//    }
//
//    public void setUsinghistories(Set<UsingHistoryEntities> usinghistories) {
//        this.usinghistories = usinghistories;
//    }
    //    @OneToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
//    private Set<UsingHistoryEntities> usingHistoryEntities = new HashSet<>();

    public UserEntities(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = 0;
    }

    public UserEntities(String username, String password, String email, double balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public UserEntities() {

    }

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }

//    public Set<UsingHistoryEntities> getUsingHistory() {
//        return usingHistoryEntities;
//    }
//
//    public void setUsingHistory(Set<UsingHistoryEntities> usingHistoryEntities) {
//        this.usingHistoryEntities = usingHistoryEntities;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double bakiye) {
        this.balance = bakiye;
    }
}
