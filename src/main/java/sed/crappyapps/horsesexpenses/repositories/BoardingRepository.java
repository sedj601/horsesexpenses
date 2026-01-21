package sed.crappyapps.horsesexpenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sed.crappyapps.horsesexpenses.model.Boarding;

public interface BoardingRepository extends JpaRepository<Boarding, Long> {}

