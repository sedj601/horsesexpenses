/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sed.crappyapps.horsesexpenses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.Bills;
import sed.crappyapps.horsesexpenses.model.Employees;
import sed.crappyapps.horsesexpenses.model.Items;
import sed.crappyapps.horsesexpenses.repositories.BillsRepository;
import sed.crappyapps.horsesexpenses.repositories.EmployeesRepository;
import sed.crappyapps.horsesexpenses.repositories.ItemsRepository;

@Controller
public class MainController 
{
    @Autowired
    private BillsRepository billsRepository;
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private EmployeesRepository employeesRepository;
            
    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("bills", billsRepository.findAll());
        model.addAttribute("items", itemsRepository.findAll());
        model.addAttribute("employees", employeesRepository.findAll());
        
        BigDecimal billsTotal = billsRepository.findAll().stream().map(Bills::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("billsTotal", billsTotal.setScale(2, RoundingMode.HALF_UP));
        
        BigDecimal itemsTotal = itemsRepository.findAll().stream().map(Items::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("itemsTotal", itemsTotal.setScale(2, RoundingMode.HALF_UP));
        
        BigDecimal employeesTotal = employeesRepository.findAll().stream().map(employees -> employees.getHours().multiply(employees.getPay())).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("employeesTotal", employeesTotal.setScale(2, RoundingMode.HALF_UP));
        
        return "index";
    }
    
    @PostMapping("/bills/add")
    public String addBill(Bills bill) {
        billsRepository.save(bill);
        return "redirect:/";
    }


    @PostMapping("/bills/delete")
    public String deleteBill(@RequestParam Long id) {
        billsRepository.deleteById(id);
        return "redirect:/"; 
    }
    
    @PostMapping("/items/delete")
    public String deleteItem(@RequestParam Long id) {
        itemsRepository.deleteById(id);
        return "redirect:/"; 
    }
    
    @PostMapping("/employees/delete")
    public String deleteEmployees(@RequestParam Long id){
        employeesRepository.deleteById(id);
        return "redirect:/";
    }
}
