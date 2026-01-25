package sed.crappyapps.horsesexpenses.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sed.crappyapps.horsesexpenses.model.Bill;
import sed.crappyapps.horsesexpenses.repository.BillRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class BillServiceTest
{
    private final BillRepository billRepository = Mockito.mock(BillRepository.class);
    private final BillService billService = new BillService(billRepository);

    @Test
    void testFindAll()
    {
        Bill bill = new Bill();
        bill.setVendor("Test Vendor");
        bill.setAmount(new BigDecimal("50.0"));
        bill.setDate("2026-01-24");

        when(billRepository.findAll()).thenReturn(List.of(bill));

        List<Bill> result = billService.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.getFirst().getVendor()).isEqualTo("Test Vendor");
    }

    @Test
    void testSave()
    {
        Bill bill = new Bill();
        bill.setVendor("Test Vendor 2");
        bill.setAmount(new BigDecimal("100.0"));
        bill.setDate("2026-11-11");

        when(billRepository.save(bill)).thenReturn(bill);

        Bill savedBill = billService.save(bill);

        assertThat(savedBill.getAmount()).isEqualTo(new BigDecimal("100.0"));
        verify(billRepository, times(1)).save(bill);
    }

    @Test
    void testDelete()
    {
        billService.deleteById(1L);
        verify(billRepository, times(1)).deleteById(1L);
    }
}
