package sed.crappyapps.horsesexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sed.crappyapps.horsesexpenses.model.Item;
import sed.crappyapps.horsesexpenses.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController
{
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public String add(Item item) {
        itemService.save(item);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        itemService.deleteById(id);
        return "redirect:/";
    }
}
