package pepsi.delivery.pepsidelivery.domain.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pepsi.delivery.pepsidelivery.domain.model.Produto;
import pepsi.delivery.pepsidelivery.domain.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/add")
	public ResponseEntity<Produto> addProduto(@Valid @RequestBody Produto produto){
		
		Produto newProduto = produtoRepository.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getall")
	public ResponseEntity<List<Produto>> getAllProduto(){
		
		List<Produto> lstProdutos = produtoRepository.findAll();
		
		if(lstProdutos.isEmpty()) {
			return new ResponseEntity<List<Produto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Produto>>(lstProdutos , HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/get/{id}")
	public ResponseEntity<Produto> getProduto(@PathVariable("id") long id){
		
		Produto findProduto = produtoRepository.findOne(id);
		
		if(findProduto == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Produto>(findProduto , HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Produto> deleteProduto(@PathVariable("id") long id){
		
		Produto deleteProduto = produtoRepository.findOne(id);
		
		if(deleteProduto == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
		
		produtoRepository.delete(deleteProduto);
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}
}
