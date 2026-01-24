package sed.crappyapps.horsesexpenses.services;

import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Items;
import sed.crappyapps.horsesexpenses.repositories.ItemsRepository;

import java.util.List;

@Service
public class ItemsService
{
    private final ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository)
    {
        this.itemsRepository = itemsRepository;
    }

    public List<Items> findAll()
    {
        return itemsRepository.findAll();
    }

    public Items save(Items item)
    {
        return itemsRepository.save(item);
    }

    public void deleteById(Long id)
    {
        itemsRepository.deleteById(id);
    }
}
