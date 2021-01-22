package scooter_sharing.app.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = 0;
    }

    public Users(String username, String password, String email, double balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public Users() {

    }

    public long getUser_ID() {
        return user_ID;
    }

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
