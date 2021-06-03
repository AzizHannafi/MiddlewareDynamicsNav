package Controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.Key;
import Entity.SalesOrder;
import Services.SalesOrderService;

@Component
@RestController

@RequestMapping(value ="SalesOrder")
public class SalesOrderController {
	SalesOrderService salesOrderService= new SalesOrderService();
	
	@RequestMapping(value = "/GetOne/{idSaleOrder}",method = RequestMethod.GET)
	public SalesOrder getOneOrder(@PathVariable("idSaleOrder") String idSaleOrder) {
		return salesOrderService.getOneSalesOrder(idSaleOrder);
	}
	
		
	@RequestMapping(value = "/GetAll/{locationCode}",method = RequestMethod.GET)
	public List<SalesOrder> getAllOrders(@PathVariable("locationCode") String locationCode) {
		return salesOrderService.GetAllSalesOrder(locationCode);
	}
	
	@RequestMapping(value = "/GetAllReleasedOrder/{locationCode}",method = RequestMethod.GET)
	public List<SalesOrder> GetAllReleasedOrder(@PathVariable("locationCode") String locationCode) {
		return salesOrderService.GetAllReleasedSalesOrder(locationCode);
	}
	
	@RequestMapping(value = "/GetAllOpenOrder/{locationCode}",method = RequestMethod.GET)
	public List<SalesOrder> GetAllOpenOrder(@PathVariable("locationCode") String locationCode) {
		return salesOrderService.GetAllOpenSalesOrder(locationCode);
	}
	
	@RequestMapping(value = "/DeleteSalesOrder",method = RequestMethod.DELETE)
	public void DeleteSalesOrder(@RequestBody Key key) {
		salesOrderService.deleteSalesOrder(key);
	}
	
	
}

