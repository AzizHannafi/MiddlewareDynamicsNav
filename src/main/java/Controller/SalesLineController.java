package Controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.Key;
import Entity.SalesLine;
import Services.SalesLineService;

@Component
@RestController
@RequestMapping(value ="SalesLine")
public class SalesLineController {

	SalesLineService SalesLineService = new SalesLineService();
	@RequestMapping(value = "/GetOne/{idSaleOrder}/{LineNo}",method = RequestMethod.GET)
	public SalesLine getOneOrder(@PathVariable("idSaleOrder") String idSaleOrder,@PathVariable("LineNo")String LineNo) {
		return SalesLineService.getOneSalesLine(idSaleOrder,LineNo);
	}
	
	@RequestMapping(value = "/GetAll",method = RequestMethod.GET)
	public List<SalesLine> getAllLine() {
		return SalesLineService.GetAllSalesLine();
	}
	
	/*
	@RequestMapping(value = "/DeleteSlaesLine/",method = RequestMethod.DELETE)
	public void DeleteSalesLine() {
		 SalesLineService.DeleteSalesLine();
	}*/
	
	@RequestMapping(value = "/DeleteSlaesLine",method = RequestMethod.DELETE)
	public void DeleteSalesLine(@RequestBody Key key) {
		 SalesLineService.DeleteSalesLine(key);
	}
	
	@RequestMapping(value = "/UpdateSlaesLine",method = RequestMethod.PUT)
	public void UpdateSlaesLine(@RequestBody SalesLine salesLine) {
		 SalesLineService.UpdateLine(salesLine);
	}
}
