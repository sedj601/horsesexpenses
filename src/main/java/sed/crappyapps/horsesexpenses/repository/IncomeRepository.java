package sed.crappyapps.horsesexpenses.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sed.crappyapps.horsesexpenses.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {}

