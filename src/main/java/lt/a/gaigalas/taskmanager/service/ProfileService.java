package lt.a.gaigalas.taskmanager.service;

import lt.a.gaigalas.taskmanager.model.Profile;
import lt.a.gaigalas.taskmanager.model.ProfileToken;
import lt.a.gaigalas.taskmanager.repository.ProfileRepository;
import lt.a.gaigalas.taskmanager.repository.ProfileTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileTokenRepository profileTokenRepository;

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

    public String login(String userName, String password) {
        Profile profile = profileRepository.findByUserName(userName);
        if (profile != null && passwordEncoder.matches(password, profile.getPassword())) {

            Optional<ProfileToken> existingToken = profileTokenRepository.findByProfile(profile);
            existingToken.ifPresent(profileTokenRepository::delete);

            ProfileToken token = generateToken(profile);
            profileTokenRepository.save(token);

            return token.getToken();
        }
        throw  new IllegalArgumentException("Invalid username or password");
    }

    private ProfileToken generateToken(Profile profile) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[24];
        secureRandom.nextBytes(tokenBytes);
        String tokenValue = Base64.getUrlEncoder().encodeToString(tokenBytes);

        long expiresIn = System.currentTimeMillis() + 3600 * 1000;

        return new ProfileToken(0, tokenValue, expiresIn, profile);
    }
}
