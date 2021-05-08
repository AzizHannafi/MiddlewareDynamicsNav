package Controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.Key;
import Entity.PurchaseLine;
import Services.PurchaseLineService;

@Component
@RestController
@RequestMapping(value ="PurchaseLine")
public class PurchaseLineController {

	PurchaseLineService PurchaseLineService= new PurchaseLineService();
	
	@RequestMapping(value = "/GetOne/{idPurchaseOrder}/{LineNo}",method = RequestMethod.GET)
	public PurchaseLine getOneOrder(@PathVariable("idPurchaseOrder") String idSaleOrder,@PathVariable("LineNo")String LineNo) {
		return PurchaseLineService.getOnePurchaseLine(idSaleOrder,LineNo);
	}
	
	@RequestMapping(value = "/GetAll",method = RequestMethod.GET)
	public List<PurchaseLine> getAllLine() {
		return PurchaseLineService.GetAllPurchaseLine();
	}
	
	@RequestMapping(value = "/DeletePurchaseLine",method = RequestMethod.DELETE)
	public void DeletePurchaseLine(@RequestBody Key key) {
		PurchaseLineService.deletePurchaseLine(key);
	}
	
}
