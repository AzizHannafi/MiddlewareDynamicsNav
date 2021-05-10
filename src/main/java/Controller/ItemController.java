package Controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.Item;
import Services.ItemService;

@Component
@RestController
@RequestMapping(value ="Items")
public class ItemController {

	ItemService itemService = new ItemService();
	
	@RequestMapping(value = "/GetOne/{idItem}",method = RequestMethod.GET)
	public Item getOneItem(@PathVariable("idItem") String idItem) {
		return itemService.getOneItem(idItem);
	}
	
	@RequestMapping(value = "/GetAll",method = RequestMethod.GET)
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
}
