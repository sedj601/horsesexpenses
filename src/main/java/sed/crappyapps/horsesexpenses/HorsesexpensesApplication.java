package sed.crappyapps.horsesexpenses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sed.crappyapps.horsesexpenses.model.Bill;
import sed.crappyapps.horsesexpenses.model.Employee;
import sed.crappyapps.horsesexpenses.model.Income;
import sed.crappyapps.horsesexpenses.model.Item;
import sed.crappyapps.horsesexpenses.repository.BillRepository;
import sed.crappyapps.horsesexpenses.repository.EmployeeRepository;
import sed.crappyapps.horsesexpenses.repository.IncomeRepository;
import sed.crappyapps.horsesexpenses.repository.ItemRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class HorsesexpensesApplication {

    public static void main(String[] args) {
            SpringApplication.run(HorsesexpensesApplication.class, args);
    }

    @Bean
    CommandLineRunner initBillsData(BillRepository billRepository) {
        return args -> {

            Bill b1 = new Bill();
            b1.setVendor("Electric Co.");
            b1.setDate("2026-01-10");
            b1.setAmount(new BigDecimal("120.50"));

            Bill b2 = new Bill();
            b2.setVendor("Water Utility");
            b2.setDate("2026-01-08");
            b2.setAmount(new BigDecimal("45.20"));

            Bill b3 = new Bill();
            b3.setVendor("Internet Provider");
            b3.setDate("2026-01-05");
            b3.setAmount(new BigDecimal("89.99"));

            billRepository.save(b1);
            billRepository.save(b2);
            billRepository.save(b3);
        };
    }
    
    @Bean
    CommandLineRunner initItemData(ItemRepository itemRepository) {
        return args -> {

            Item item = new Item();
            item.setName("Lumber");
            item.setQuantity(new BigDecimal("15.00"));
            item.setCost(new BigDecimal("75.00"));

            Item item2 = new Item();
            item2.setName("Concrete Bags");
            item2.setQuantity(new BigDecimal("8.00"));
            item2.setCost(new BigDecimal("48.50"));

            Item item3 = new Item();
            item3.setName("Nails");
            item3.setQuantity(new BigDecimal("3"));
            item3.setCost(new BigDecimal("12.28"));

            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
        };
    }
    
    @Bean
    CommandLineRunner initEmployeesData(EmployeeRepository employeeRepository) {
        return args -> {

            Employee employee = new Employee();
            employee.setName("John Carter");
            employee.setHours(new BigDecimal(8));
            employee.setPay(new BigDecimal("160.88"));

            Employee employee2 = new Employee();
            employee2.setName("Maria Lopez");
            employee2.setHours(new BigDecimal(6));
            employee2.setPay(new BigDecimal("212.13"));

            Employee employee3 = new Employee();
            employee3.setName("Sam Patel");
            employee3.setHours(new BigDecimal(5));
            employee3.setPay(new BigDecimal("100.00"));

            employeeRepository.save(employee);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);
        };
    }

    @Bean
    CommandLineRunner initIncomeData(IncomeRepository incomeRepository) {
        return args -> {

            Income income1 = new Income();
            income1.setType("Horse Boarding");
            income1.setAmount(new BigDecimal("0.00"));

            Income income2 = new Income();
            income2.setType("Donations");
            income2.setAmount(new BigDecimal("5000.00"));

            Income income3 = new Income();
            income3.setType("Lessons");
            income3.setAmount(new BigDecimal("2000.00"));

            incomeRepository.save(income1);
            incomeRepository.save(income2);
            incomeRepository.save(income3);
        };
    }
}
