package sed.crappyapps.horsesexpenses.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sed.crappyapps.horsesexpenses.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {}

