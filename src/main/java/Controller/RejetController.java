package Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.Rejet;
import Services.RejetService;

@Component
@RestController
@RequestMapping(value ="Rejet")
public class RejetController {
	RejetService RejetService= new RejetService();
	
	
	@RequestMapping(value = "/add/{idCommande}/{IDItem}",method = RequestMethod.POST)
	public void addToReject(@PathVariable("idCommande") String idCommande,@PathVariable("IDItem") String IDItem) {
		 RejetService.addToReject(idCommande,IDItem);
	}
	
	@RequestMapping(value = "/GetOne",method = RequestMethod.POST)
	public Rejet getOneRejet(@RequestBody Rejet rejet) {
		return RejetService.getItemByID(rejet);
	}
	
}
