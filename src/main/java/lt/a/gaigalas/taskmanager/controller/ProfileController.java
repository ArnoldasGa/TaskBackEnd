package lt.a.gaigalas.taskmanager.controller;

import jakarta.validation.Valid;
import lt.a.gaigalas.taskmanager.exception.ResourceNotFoundException;
import lt.a.gaigalas.taskmanager.model.Profile;
import lt.a.gaigalas.taskmanager.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody Profile profile) {
        try {
            profileService.registerProfile(profile);
            return ResponseEntity.status(200).body("Profile registered successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        try {
            String userName = credentials.get("userName");
            String password = credentials.get("password");
            String token = profileService.login(userName, password);
            return ResponseEntity.ok(token);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}
