package cl.inicia.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.inicia.dictionary.domain.User;
import cl.inicia.dictionary.domain.Word;
import cl.inicia.dictionary.service.MasterService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private MasterService service;	
	
	@RequestMapping(path = "/words", method = RequestMethod.GET)	
	public ResponseEntity<List<Word>> words(OAuth2Authentication auth){
		String username = auth.getName();
		return new ResponseEntity<List<Word>>(service.getAll(username), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public ResponseEntity<User> details(OAuth2Authentication auth){
		return new ResponseEntity<User>(service.findUserByUsername(auth.getName()), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/isAuthenticated", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public boolean isAuthenticated(){
		return true;
	}
}
