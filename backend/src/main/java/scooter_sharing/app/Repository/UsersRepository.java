package scooter_sharing.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scooter_sharing.app.Entities.UserEntities;

@Repository
public interface UsersRepository extends JpaRepository<UserEntities, Long> {

}
