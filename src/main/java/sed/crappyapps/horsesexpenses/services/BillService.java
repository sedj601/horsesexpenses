package sed.crappyapps.horsesexpenses.services;


import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Bills;
import sed.crappyapps.horsesexpenses.repositories.BillsRepository;

import java.util.List;

@Service
public class BillService {
    private final BillsRepository billsRepository;

    public BillService(BillsRepository billsRepository)
    {
        this.billsRepository = billsRepository;
    }

    public List<Bills> findAll()
    {
        return billsRepository.findAll();
    }

    public Bills save(Bills bill)
    {
        return billsRepository.save(bill);
    }

    public void deleteById(Long id)
    {
        billsRepository.deleteById(id);
    }
}
