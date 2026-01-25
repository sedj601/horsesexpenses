package sed.crappyapps.horsesexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.Income;
import sed.crappyapps.horsesexpenses.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeController
{
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping("/add")
    public String add(Income income)
    {
        incomeService.save(income);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id)
    {
        incomeService.deleteById(id);
        return "redirect:/";
    }

//    @PostMapping("/update")
//    public String updateIncome(BoardingCost boardingCost) {
//
//    }
}
