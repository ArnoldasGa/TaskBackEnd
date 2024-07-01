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
        String encodedPassword = passwordEncoder.encode(profile.getPassword());
        profile.setPassword(encodedPassword);

        return profileRepository.save(profile);
    }
}
