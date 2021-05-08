package Controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.Key;
import Entity.PurchaseOrders;
import Services.PurchaseOrdersService;

@Component
@RestController

@RequestMapping(value ="PurchaseOrders")
public class PurchaseOrdersController {
	
	PurchaseOrdersService purchaseordersservice = new PurchaseOrdersService();
	
	@RequestMapping(value = "/GetOne/{idPurchaseOrder}",method = RequestMethod.GET)
	public PurchaseOrders getOneOrder(@PathVariable("idPurchaseOrder") String idPurchaseOrder) {
		return purchaseordersservice.getOnePurchaseOrder(idPurchaseOrder);
	}
	
	@RequestMapping(value = "/GetAll",method = RequestMethod.GET)
	public List<PurchaseOrders> getAllOrder() {
		return purchaseordersservice.getAllPurchaseOrder();
	}
	
	@RequestMapping(value = "/DeletePurchaseOrders",method = RequestMethod.DELETE)
	public void DeletePurchaseOrders(@RequestBody Key key) {
		purchaseordersservice.deletePurchaseOrders(key);
	}
}
