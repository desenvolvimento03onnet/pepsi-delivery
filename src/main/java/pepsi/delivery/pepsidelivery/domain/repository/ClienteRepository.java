package pepsi.delivery.pepsidelivery.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepsi.delivery.pepsidelivery.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	
	public Cliente findByEmailAndSenha(String email, String senha);
}
