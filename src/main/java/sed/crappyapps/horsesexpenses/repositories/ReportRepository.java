package sed.crappyapps.horsesexpenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sed.crappyapps.horsesexpenses.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{}