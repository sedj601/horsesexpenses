/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sed.crappyapps.horsesexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sed.crappyapps.horsesexpenses.model.HorseExpense;
import sed.crappyapps.horsesexpenses.model.Income;
import sed.crappyapps.horsesexpenses.service.BillService;
import sed.crappyapps.horsesexpenses.service.EmployeeService;
import sed.crappyapps.horsesexpenses.service.HorseExpenseService;
import sed.crappyapps.horsesexpenses.service.IncomeService;
import sed.crappyapps.horsesexpenses.service.ItemService;
import sed.crappyapps.horsesexpenses.service.ReportService;
import sed.crappyapps.horsesexpenses.service.TotalService;

import java.math.RoundingMode;

@Controller
public class MainController 
{
    private final BillService billService;
    private final ItemService itemService;
    private final EmployeeService employeeService;
    private final IncomeService incomeService;
    private final ReportService reportService;
    private final HorseExpenseService horseExpenseService;

    public MainController(BillService billService, ItemService itemService, EmployeeService employeeService, IncomeService incomeService, ReportService reportService, HorseExpenseService horseExpenseService)
    {
        this.billService = billService;
        this.itemService = itemService;
        this.employeeService = employeeService;
        this.incomeService = incomeService;
        this.reportService = reportService;
        this.horseExpenseService = horseExpenseService;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("billList", billService.findAll());
        model.addAttribute("itemList", itemService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("incomeList", incomeService.findAll());
        model.addAttribute("horseExpenseList", horseExpenseService.findAll());
        model.addAttribute("reportOutput", reportService.findAll());

        Income horseBoardingIncome = incomeService.findAll().getFirst();
        model.addAttribute("horseBoardingId", horseBoardingIncome.getId());


        model.addAttribute("billTotal", TotalService.CalculateBillsTotal(billService.findAll()).setScale(2, RoundingMode.HALF_UP));
        model.addAttribute("itemTotal", TotalService.CalculateItemsTotal(itemService.findAll()).setScale(2, RoundingMode.HALF_UP));
        model.addAttribute("employeeTotal", TotalService.CalculateEmployeesTotal(employeeService.findAll()).setScale(2, RoundingMode.HALF_UP));
        model.addAttribute("incomeTotal", TotalService.CalculateIncomeTotal(incomeService.findAll()).setScale(2, RoundingMode.HALF_UP));

        return "index";
    }
}
