package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {


    Role findByName(String name);
}

