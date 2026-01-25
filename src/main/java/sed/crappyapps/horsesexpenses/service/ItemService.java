package sed.crappyapps.horsesexpenses.service;

import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Item;
import sed.crappyapps.horsesexpenses.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService
{
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll()
    {
        return itemRepository.findAll();
    }

    public Item save(Item item)
    {
        return itemRepository.save(item);
    }

    public void deleteById(Long id)
    {
        itemRepository.deleteById(id);
    }
}
