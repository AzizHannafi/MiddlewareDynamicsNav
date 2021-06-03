package Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Services.PreparationService;

@Component
@RestController
@RequestMapping(value ="Preparation")
public class PreparationController {

	PreparationService PreparationService= new PreparationService();
	
	@RequestMapping(value = "/add/{idUser}/{IDCommande}",method = RequestMethod.POST)
	public void addToReject(@PathVariable("idUser") String idUser,@PathVariable("IDCommande") String IDCommande) {
		PreparationService.addToPreparetion(idUser,IDCommande);
	}
}
