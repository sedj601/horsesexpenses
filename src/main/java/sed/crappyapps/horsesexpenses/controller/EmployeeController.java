package sed.crappyapps.horsesexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.Employee;
import sed.crappyapps.horsesexpenses.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public String add(Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam Long id){
        employeeService.deleteById(id);
        return "redirect:/";
    }
}
