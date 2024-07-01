package lt.a.gaigalas.taskmanager.controller;

import lt.a.gaigalas.taskmanager.model.Profile;
import lt.a.gaigalas.taskmanager.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/register")
    public Profile register(@RequestBody Profile profile) {
        return profileService.registerProfile(profile);
    }
}
