package lt.a.gaigalas.taskmanager.model;

import jakarta.persistence.*;
import lt.a.gaigalas.taskmanager.model.Profile;

@Entity
@Table(name = "userToken")
public class ProfileToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String token;

    public ProfileToken(long id, String token) {
        this.id = id;
        this.token = token;
    }

    public ProfileToken() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
