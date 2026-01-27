package sed.crappyapps.horsesexpenses.service;

import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.HorseExpense;
import sed.crappyapps.horsesexpenses.repository.HorseExpenseRepository;

import java.util.List;

@Service
public class HorseExpenseService
{
    private final HorseExpenseRepository horseExpenseRepository;

    public HorseExpenseService(HorseExpenseRepository horseExpenseRepository)
    {
        this.horseExpenseRepository = horseExpenseRepository;
    }

    public List<HorseExpense> findAll()
    {
        return horseExpenseRepository.findAll();
    }

    public HorseExpense save(HorseExpense horseExpense)
    {
        return horseExpenseRepository.save(horseExpense);
    }

    public void deleteById(Long id)
    {
        horseExpenseRepository.deleteById(id);
    }
}
