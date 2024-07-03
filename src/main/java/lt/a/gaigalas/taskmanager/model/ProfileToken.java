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

    private long expiresIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    public ProfileToken(long id, String token, long expiresIn, Profile profile) {
        this.id = id;
        this.token = token;
        this.expiresIn = expiresIn;
        this.profile = profile;
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

    public long getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
