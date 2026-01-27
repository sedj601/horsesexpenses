package sed.crappyapps.horsesexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.HorseExpense;
import sed.crappyapps.horsesexpenses.model.Item;
import sed.crappyapps.horsesexpenses.service.HorseExpenseService;
import sed.crappyapps.horsesexpenses.service.ItemService;

@Controller
@RequestMapping("/horse-expense")
public class HorseExpenseController
{
    private final HorseExpenseService horseExpenseService;

    public HorseExpenseController(HorseExpenseService horseExpenseService) {
        this.horseExpenseService = horseExpenseService;
    }

    @PostMapping("/add")
    public String add(HorseExpense horseExpense) {
        horseExpenseService.save(horseExpense);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        horseExpenseService.deleteById(id);
        return "redirect:/";
    }
}
