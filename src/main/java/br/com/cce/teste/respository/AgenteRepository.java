package br.com.cce.teste.respository;

import br.com.cce.teste.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Long> {

}
