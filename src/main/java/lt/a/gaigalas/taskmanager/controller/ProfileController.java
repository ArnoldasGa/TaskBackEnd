package lt.a.gaigalas.taskmanager.controller;

import jakarta.validation.Valid;
import lt.a.gaigalas.taskmanager.exception.ResourceNotFoundException;
import lt.a.gaigalas.taskmanager.model.Profile;
import lt.a.gaigalas.taskmanager.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String password) {
        return ResponseEntity.status(200).body("Login successful");
    }

}
