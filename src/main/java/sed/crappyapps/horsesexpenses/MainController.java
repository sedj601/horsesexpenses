/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sed.crappyapps.horsesexpenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.Bills;
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
