package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Donation;




@Repository
public interface DonationRepo extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(a.quantity) FROM Donation a")
    long countAllByQuantity();

}
