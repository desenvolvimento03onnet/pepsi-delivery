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

import pepsi.delivery.pepsidelivery.domain.model.Pedido;
import pepsi.delivery.pepsidelivery.domain.repository.PedidoRepository;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {

	@Autowired
	private PedidoRepository pedidoRepository;

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/add")
	public ResponseEntity<Pedido> savePedido(@Valid @RequestBody Pedido pedido) {

		Pedido newPedido = pedidoRepository.save(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPedido);

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getall")
	public ResponseEntity<List<Pedido>> getAllPedido(){
	
		List<Pedido> lstPedido = pedidoRepository.findAll();
		
		if(lstPedido.isEmpty()) {
			return new ResponseEntity<List<Pedido>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pedido>>(lstPedido, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/get/{id}")
	public ResponseEntity<Pedido> getPedido(@PathVariable("id") long id){
		
		Pedido findPedido = pedidoRepository.findOne(id);
		
		if(findPedido == null) {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pedido>(findPedido, HttpStatus.OK);
	}
}
