package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.User;

import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    @Modifying
    @Query("UPDATE User a SET a.locked = TRUE WHERE a.email=?1")
    int blockUser(String email);

    @Modifying
    @Transactional
    @Query("UPDATE User a SET a.enabled = TRUE WHERE a.email=?1")
    int enableUser(String email);
}
