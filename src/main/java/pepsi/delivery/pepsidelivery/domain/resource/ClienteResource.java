package pepsi.delivery.pepsidelivery.domain.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pepsi.delivery.pepsidelivery.domain.model.Cliente;
import pepsi.delivery.pepsidelivery.domain.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/add")
	public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody Cliente cliente){
		
		Cliente newCliente = clienteRepository.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getall")
	public ResponseEntity<List<Cliente>> getAllClient(){
		
		List<Cliente> lstClient = clienteRepository.findAll();
		
		if(lstClient.isEmpty()) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cliente>>(lstClient, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/get/{id}")
	public ResponseEntity<Cliente> getClient(@PathVariable("id") long id){
		
		Cliente getCliente = clienteRepository.findOne(id);
		
		if(getCliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(getCliente, HttpStatus.OK);
		
	}

}
