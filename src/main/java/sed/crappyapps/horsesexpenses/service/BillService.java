package sed.crappyapps.horsesexpenses.service;


import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Bill;
import sed.crappyapps.horsesexpenses.repository.BillRepository;

import java.util.List;

@Service
public class BillService
{
    private final BillRepository billRepository;

    public BillService(BillRepository billRepository)
    {
        this.billRepository = billRepository;
    }

    public List<Bill> findAll()
    {
        return billRepository.findAll();
    }

    public Bill save(Bill bill)
    {
        return billRepository.save(bill);
    }

    public void deleteById(Long id)
    {
        billRepository.deleteById(id);
    }
}
