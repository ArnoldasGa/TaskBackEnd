package lt.a.gaigalas.taskmanager.repository;
import lt.a.gaigalas.taskmanager.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    Profile findByUserName(String userName);
}
