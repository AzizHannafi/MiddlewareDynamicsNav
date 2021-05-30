package Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Services.ReceptionService;

@Component
@RestController
@RequestMapping(value ="Reception")
public class ReceptionController {
	ReceptionService ReceptionService =new ReceptionService();
	
	@RequestMapping(value = "/add/{idCommande}/{IDItem}/{IDUser}",method = RequestMethod.POST)
	public void addToRecption(@PathVariable("idCommande") String idCommande,@PathVariable("IDItem") String IDItem,@PathVariable("IDUser") String IDUser) {
		ReceptionService.addToReception(idCommande,IDItem,IDUser);
	}

}
