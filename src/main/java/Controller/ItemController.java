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
	
	@RequestMapping(value = "/GetAllWithShelf",method = RequestMethod.GET)
	public List<Item> GetAllWithShelf() {
		return itemService.getAllItemsWithShelf();
	}
	
	@RequestMapping(value = "/updateEmplacement/{idItem}/{idEmplacement}",method = RequestMethod.PUT)
	public void updateEmplacement(@PathVariable("idItem")String idItem, @PathVariable("idEmplacement")String idEmplacement) {
		 itemService.updateEmplacement(idItem,idEmplacement);
	}
	@RequestMapping(value = "/GetOneWithShelf/{idItem}",method = RequestMethod.POST)
	public Item GetOneWithShelf(@PathVariable("idItem") String idItem) {
		return itemService.GetOneItemWithShelf(idItem);
	}
	
	@RequestMapping(value = "/GetBilanPurchaseOneItem/{idItem}",method = RequestMethod.GET)
	public Item GetBilanOneItem(@PathVariable("idItem") String idItem) {
		return itemService.GetPurchaseItem(idItem);
	}
	
	@RequestMapping(value = "/GetBilanSalesOneItem/{idItem}",method = RequestMethod.GET)
	public Item GetBilanSalesOneItem(@PathVariable("idItem") String idItem) {
		return itemService.GetSalesItem(idItem);
	}
	
}
