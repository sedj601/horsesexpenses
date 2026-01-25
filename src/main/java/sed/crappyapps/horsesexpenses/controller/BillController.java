package sed.crappyapps.horsesexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.Bill;
import sed.crappyapps.horsesexpenses.service.BillService;

@Controller
@RequestMapping("/bill")

public class BillController
{
    private final BillService billService;

    public BillController(BillService billService)
    {
        this.billService = billService;
    }

    @PostMapping("/add")
    public String add(Bill bill) {
        billService.save(bill);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        billService.deleteById(id);
        return "redirect:/";
    }

}
