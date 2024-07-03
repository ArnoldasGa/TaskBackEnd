package lt.a.gaigalas.taskmanager.repository;

import lt.a.gaigalas.taskmanager.model.ProfileToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileTokenRepository extends JpaRepository<ProfileToken, Long> {
    ProfileToken findByToken(String token);
}