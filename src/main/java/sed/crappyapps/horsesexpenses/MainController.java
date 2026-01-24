/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sed.crappyapps.horsesexpenses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.*;
import sed.crappyapps.horsesexpenses.services.*;

@Controller
public class MainController 
{
    @Autowired
    private BillService billService;
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private ReportService reportService;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("bills", billService.findAll());
        model.addAttribute("items", itemsService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("incomes", incomeService.findAll());
        Income horseBoardingIncome = incomeService.findAll().getFirst();
        model.addAttribute("horseBoardingId", horseBoardingIncome.getId());
        model.addAttribute("report", horseBoardingIncome);


        BigDecimal billsTotal = billService.findAll().stream().map(Bills::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("billsTotal", billsTotal.setScale(2, RoundingMode.HALF_UP));
        
        BigDecimal itemsTotal = itemsService.findAll().stream().map(item -> item.getQuantity().multiply(item.getCost())).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("itemsTotal", itemsTotal.setScale(2, RoundingMode.HALF_UP));
        
        BigDecimal employeesTotal = employeeService.findAll().stream().map(employees -> employees.getHours().multiply(employees.getPay())).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("employeesTotal", employeesTotal.setScale(2, RoundingMode.HALF_UP));

        BigDecimal incomeTotal = incomeService.findAll().stream().map(Income::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("incomeTotal", incomeTotal.setScale(2, RoundingMode.HALF_UP));

        model.addAttribute("reportOutput", reportService.findAll());

        return "index";
    }
    
    @PostMapping("/bills/add")
    public String addBill(Bills bill) {
        billService.save(bill);
        return "redirect:/";
    }


    @PostMapping("/bills/delete")
    public String deleteBill(@RequestParam Long id) {
        billService.deleteById(id);
        return "redirect:/"; 
    }

    @PostMapping("/items/add")
    public String addItem(Items item) {
        itemsService.save(item);
        return "redirect:/";
    }

    @PostMapping("/items/delete")
    public String deleteItem(@RequestParam Long id) {
        itemsService.deleteById(id);
        return "redirect:/"; 
    }

    @PostMapping("/employees/add")
    public String addEmployee(Employees employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @PostMapping("/employees/delete")
    public String deleteEmployees(@RequestParam Long id){
        employeeService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/incomes/add")
    public String addIncome(Income income) {
        incomeService.save(income);
        return "redirect:/";
    }

    @PostMapping("/incomes/delete")
    public String deleteIncome(@RequestParam Long id){
        incomeService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/income/update")
    public String updateIncome(BoardingCost boardingCost) {
        Income horseBoardingIncome = incomeService.findById(boardingCost.getId()).orElseThrow(() -> new RuntimeException("User not found"));;
        horseBoardingIncome.setAmount(boardingCost.getPricePerHorse().multiply(new BigDecimal(boardingCost.getNumberOfHorses())));
        incomeService.save(horseBoardingIncome);

        int initialNumber = Math.max(boardingCost.getNumberOfHorses() - 3, 0);
        int endNumber = boardingCost.getNumberOfHorses() + 7;
        BigDecimal billsTotal = billService.findAll().stream().map(Bills::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal itemsTotal = itemsService.findAll().stream().map(item -> item.getQuantity().multiply(item.getCost())).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal employeesTotal = employeeService.findAll().stream().map(employees -> employees.getHours().multiply(employees.getPay())).reduce(BigDecimal.ZERO, BigDecimal::add);

        List<Income> incomeListMinusHorseBoarding = new ArrayList<>(incomeService.findAll());
        incomeListMinusHorseBoarding.removeIf(income -> income.getType().equals("Horse Boarding"));
        BigDecimal incomeTotalMinusBoardingCost = incomeListMinusHorseBoarding.stream().map(Income::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expenseTotal = billsTotal.add(itemsTotal.add(employeesTotal));

        for(int i = initialNumber; i < endNumber; i++)
        {
            Report report = new Report(new BigDecimal(i), boardingCost.getPricePerHorse(), expenseTotal, incomeTotalMinusBoardingCost);
            reportService.save(report);
        }

        return "redirect:/";
    }
}
