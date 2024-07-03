package lt.a.gaigalas.taskmanager.repository;

import lt.a.gaigalas.taskmanager.model.Profile;
import lt.a.gaigalas.taskmanager.model.ProfileToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileTokenRepository extends JpaRepository<ProfileToken, Long> {
    ProfileToken findByToken(String token);
    Optional<ProfileToken> findByProfile(Profile profile);
}