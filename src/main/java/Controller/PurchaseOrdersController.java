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
	
	@RequestMapping(value = "/GetAll/{locationCode}",method = RequestMethod.GET)
	public List<PurchaseOrders> getAllOrder(@PathVariable("locationCode") String locationCode) {
		return purchaseordersservice.getAllPurchaseOrder(locationCode);
	}
	
	@RequestMapping(value = "/GetAll",method = RequestMethod.GET)
	public List<PurchaseOrders> getAllOrder() {
		return purchaseordersservice.getAllPurchaseOrder();
	}
	
	@RequestMapping(value = "/GetAllOpenPurchaseOrders",method = RequestMethod.GET)
	public List<PurchaseOrders> GetAllOpenPurchaseOrders() {
		return purchaseordersservice.GetAllOpenPurchaseOrders();
	}
	
	@RequestMapping(value = "/GetAllReleasedPurchaseOrders",method = RequestMethod.GET)
	public List<PurchaseOrders> GetAllReleasedPurchaseOrders() {
		return purchaseordersservice.GetAllReleasedPurchaseOrders();
	}
	
	@RequestMapping(value = "/DeletePurchaseOrders",method = RequestMethod.DELETE)
	public void DeletePurchaseOrders(@RequestBody Key key) {
		purchaseordersservice.deletePurchaseOrders(key);
	}
	
	@RequestMapping(value = "/UpdateStatus/{idPurchaseOrder}/{status}",method = RequestMethod.PUT)
	public void UpdateStatus(@PathVariable("idPurchaseOrder") String idPurchaseOrder,@PathVariable("status") String status) {
		purchaseordersservice.updateStatus(idPurchaseOrder,status);
	}
	
	@RequestMapping(value = "/GetOneRelesed/{idPurchaseOrder}",method = RequestMethod.GET)
	public List<PurchaseOrders>  getOneReleasedPurchaseOrder(@PathVariable("idPurchaseOrder") String idPurchaseOrder) {
		return purchaseordersservice.getOneReleasedPurchaseOrder(idPurchaseOrder);
	}
	
	@RequestMapping(value = "/GetOneOpen/{idPurchaseOrder}",method = RequestMethod.GET)
	public List<PurchaseOrders>  getOneOpenPurchaseOrder(@PathVariable("idPurchaseOrder") String idPurchaseOrder) {
		return purchaseordersservice.getOneOpenPurchaseOrder(idPurchaseOrder);
	}
}
