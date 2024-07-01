package lt.a.gaigalas.taskmanager.service;

import lt.a.gaigalas.taskmanager.model.Profile;
import lt.a.gaigalas.taskmanager.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Profile registerProfile(Profile profile) {
        if (profileRepository.existsByEmail(profile.getEmail())) {
            throw  new IllegalArgumentException("Email already in use");
        }
        if (profileRepository.existsByUserName(profile.getUserName())) {
            throw  new IllegalArgumentException("Username already in use");
        }
        String encodedPassword = passwordEncoder.encode(profile.getPassword());
        profile.setPassword(encodedPassword);

        return profileRepository.save(profile);
    }

    public Profile login(String userName, String password) {
        if (profileRepository.existsByUserNameAndPassword(userName, password)) {

        }
        throw  new IllegalArgumentException("Invalid username or password");
    }
}
