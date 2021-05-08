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
	
		
	@RequestMapping(value = "/GetAll",method = RequestMethod.GET)
	public List<SalesOrder> getAllOrders() {
		return salesOrderService.GetAllSalesOrder();
	}
	
	@RequestMapping(value = "/GetAllReleasedOrder",method = RequestMethod.GET)
	public List<SalesOrder> GetAllReleasedOrder() {
		return salesOrderService.GetAllReleasedSalesOrder();
	}
	
	@RequestMapping(value = "/GetAllOpenOrder",method = RequestMethod.GET)
	public List<SalesOrder> GetAllOpenOrder() {
		return salesOrderService.GetAllOpenSalesOrder();
	}
	
	@RequestMapping(value = "/DeleteSalesOrder",method = RequestMethod.DELETE)
	public void DeleteSalesOrder(@RequestBody Key key) {
		salesOrderService.deleteSalesOrder(key);
	}
	
	
}

