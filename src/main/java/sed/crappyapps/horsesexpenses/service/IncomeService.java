package sed.crappyapps.horsesexpenses.service;

import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Income;
import sed.crappyapps.horsesexpenses.repository.IncomeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService
{
    public final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository)
    {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> findAll()
    {
        return incomeRepository.findAll();
    }

    public Income save(Income income)
    {
        return incomeRepository.save(income);
    }

    public Optional<Income> findById(Long id)
    {
        return incomeRepository.findById(id);
    }

    public void deleteById(Long id)
    {
        incomeRepository.deleteById(id);
    }

}
