package Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Services.SupprimerService;

@Component
@RestController
@RequestMapping(value ="Supprimer")
public class SupprimerController {
	
	SupprimerService SupprimerService= new SupprimerService();

	@RequestMapping(value = "/add/{idCommande}/{IDItem}/{IDUser}",method = RequestMethod.POST)
	public void addToDelete(@PathVariable("idCommande") String idCommande,@PathVariable("IDItem") String IDItem,@PathVariable("IDUser") String IDUser) {
		SupprimerService.addToDelete(idCommande,IDItem,IDUser);
	}
}
