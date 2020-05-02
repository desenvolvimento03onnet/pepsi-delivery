package pepsi.delivery.pepsidelivery.domain.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pepsi.delivery.pepsidelivery.domain.model.Cliente;
import pepsi.delivery.pepsidelivery.domain.model.dto.UserAut;
import pepsi.delivery.pepsidelivery.domain.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/aut")
public class AutServices {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/user")
	public ResponseEntity<UserAut> autenticate(@Valid @RequestBody UserAut user){
		Cliente cliente = clienteRepository.findByEmailAndSenha(user.getEmail(), user.getSenha());
		
		if(cliente == null) {
			return new ResponseEntity<UserAut>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<UserAut>(HttpStatus.OK);
	}
}
