package sed.crappyapps.horsesexpenses.services;

import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Report;
import sed.crappyapps.horsesexpenses.repositories.ReportRepository;

import java.util.List;

@Service
public class ReportService
{
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository)
    {
        this.reportRepository = reportRepository;
    }

    public List<Report> findAll()
    {
        return reportRepository.findAll();
    }

    public Report save(Report report)
    {
        return reportRepository.save(report);
    }

    public void deleteById(Long id)
    {
        reportRepository.deleteById(id);
    }
}
