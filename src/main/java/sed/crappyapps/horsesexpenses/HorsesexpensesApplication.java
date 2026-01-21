package sed.crappyapps.horsesexpenses;

import java.math.BigDecimal;
import sed.crappyapps.horsesexpenses.model.Bills;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sed.crappyapps.horsesexpenses.model.Employees;
import sed.crappyapps.horsesexpenses.repositories.BillsRepository;
import sed.crappyapps.horsesexpenses.model.Items;
import sed.crappyapps.horsesexpenses.repositories.EmployeesRepository;
import sed.crappyapps.horsesexpenses.repositories.ItemsRepository;

@SpringBootApplication
@EnableJpaRepositories("sed.crappyapps.horsesexpenses.repositories")

public class HorsesexpensesApplication {

    public static void main(String[] args) {
            SpringApplication.run(HorsesexpensesApplication.class, args);
    }

    @Bean
    CommandLineRunner initBillsData(BillsRepository billsRepository) {
        return args -> {

            Bills b1 = new Bills();
            b1.setVendor("Electric Co.");
            b1.setDate("2026-01-10");
            b1.setAmount(new BigDecimal("120.50"));

            Bills b2 = new Bills();
            b2.setVendor("Water Utility");
            b2.setDate("2026-01-08");
            b2.setAmount(new BigDecimal("45.20"));

            Bills b3 = new Bills();
            b3.setVendor("Internet Provider");
            b3.setDate("2026-01-05");
            b3.setAmount(new BigDecimal("89.99"));

            billsRepository.save(b1);
            billsRepository.save(b2);
            billsRepository.save(b3);
        };
    }
    
    @Bean
    CommandLineRunner initItemsData(ItemsRepository itemsRepository) {
        return args -> {

            Items items = new Items();
            items.setName("Lumber");
            items.setQuantity(new BigDecimal("15.00"));
            items.setCost(new BigDecimal("75.00"));

            Items items2 = new Items();
            items2.setName("Concrete Bags");
            items2.setQuantity(new BigDecimal("8.00"));
            items2.setCost(new BigDecimal("48.50"));

            Items items3 = new Items();
            items3.setName("Nails");
            items3.setQuantity(new BigDecimal("3"));
            items3.setCost(new BigDecimal("12.28"));

            itemsRepository.save(items);
            itemsRepository.save(items2);
            itemsRepository.save(items3);
        };
    }
    
    @Bean
    CommandLineRunner initEmployeesData(EmployeesRepository employeesRepository) {
        return args -> {

            Employees employees = new Employees();
            employees.setName("John Carter");
            employees.setHours(new BigDecimal(8));
            employees.setPay(new BigDecimal("160.88"));

            Employees employees2 = new Employees();
            employees2.setName("Maria Lopez");
            employees2.setHours(new BigDecimal(6));
            employees2.setPay(new BigDecimal("212.13"));

            Employees employees3 = new Employees();
            employees3.setName("Sam Patel");
            employees3.setHours(new BigDecimal(5));
            employees3.setPay(new BigDecimal("100.00"));

            employeesRepository.save(employees);
            employeesRepository.save(employees2);
            employeesRepository.save(employees3);
        };
    }
}
