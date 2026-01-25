package sed.crappyapps.horsesexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sed.crappyapps.horsesexpenses.model.BoardingCost;
import sed.crappyapps.horsesexpenses.model.Income;
import sed.crappyapps.horsesexpenses.model.Report;
import sed.crappyapps.horsesexpenses.model.Bill;
import sed.crappyapps.horsesexpenses.service.BillService;
import sed.crappyapps.horsesexpenses.service.EmployeeService;
import sed.crappyapps.horsesexpenses.service.IncomeService;
import sed.crappyapps.horsesexpenses.service.ItemService;
import sed.crappyapps.horsesexpenses.service.ReportService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;
    private final IncomeService incomeService;
    private final BillService billService;
    private final ItemService itemService;
    private final EmployeeService employeeService;

    public ReportController(
            ReportService reportService,
            IncomeService incomeService,
            BillService billService,
            ItemService itemService,
            EmployeeService employeeService
    ) {
        this.reportService = reportService;
        this.incomeService = incomeService;
        this.billService = billService;
        this.itemService = itemService;
        this.employeeService = employeeService;
    }

    @PostMapping("/update-income")
    public String updateIncome(BoardingCost boardingCost) {
        Income horseBoardingIncome = incomeService.findById(boardingCost.getId()).orElseThrow(() -> new RuntimeException("Boarding Cost not found!"));

        horseBoardingIncome.setAmount(boardingCost.getPricePerHorse().multiply(new BigDecimal(boardingCost.getNumberOfHorses())));
        incomeService.save(horseBoardingIncome);

        int initialNumber = Math.max(boardingCost.getNumberOfHorses() - 3, 0);
        int endNumber = boardingCost.getNumberOfHorses() + 7;
        BigDecimal billsTotal = billService.findAll().stream().map(Bill::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal itemsTotal = itemService.findAll().stream().map(item -> item.getQuantity().multiply(item.getCost())).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal employeesTotal = employeeService.findAll().stream().map(employee -> employee.getHours().multiply(employee.getPay())).reduce(BigDecimal.ZERO, BigDecimal::add);

        List<Income> incomeListMinusHorseBoarding = new ArrayList<>(incomeService.findAll());
        incomeListMinusHorseBoarding.removeIf(income -> income.getType().equals("Horse Boarding"));
        BigDecimal incomeTotalMinusBoardingCost = incomeListMinusHorseBoarding.stream().map(Income::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expenseTotal = billsTotal.add(itemsTotal.add(employeesTotal));

        for (int i = initialNumber; i < endNumber; i++) {
            Report report = new Report(new BigDecimal(i), boardingCost.getPricePerHorse(), expenseTotal, incomeTotalMinusBoardingCost);
            reportService.save(report);
        }

        return "redirect:/";
    }
}
