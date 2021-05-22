package Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.User;
import Services.UserService;

@Component
@RestController
@RequestMapping(value ="Users")
public class UserController {
	
	UserService userservice = new UserService();
	
	@RequestMapping(value = "/Login",method = RequestMethod.GET)
	public User authenticate(@RequestBody User user) {
		return userservice.authentificate(user);
	}
	
	
	@RequestMapping(value = "/GetUserByID/{idUser}",method = RequestMethod.GET)
	public User getUserByID(@PathVariable("idUser") int idUser) {
		return userservice.getUserByID(idUser);
	}
}
