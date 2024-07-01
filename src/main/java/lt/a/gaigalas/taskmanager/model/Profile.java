package lt.a.gaigalas.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Email is needed")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank (message = "First name is needed")
    private String firstName;
    @NotBlank(message = "Last name is needed")
    private String lastName;
    @NotBlank(message = "Password is needed")
    private String password;
    @NotBlank(message = "Username is needed")
    private String userName;
    @OneToOne
    @JoinColumn(name = "token_id")
    private ProfileToken profileToken;

    public Profile(String email, String firstName, String lastName, String password, String userName, ProfileToken profileToken) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.profileToken = profileToken;
    }

    public Profile() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ProfileToken getProfileToken() {
        return profileToken;
    }

    public void setProfileToken(ProfileToken profileToken) {
        this.profileToken = profileToken;
    }
}
