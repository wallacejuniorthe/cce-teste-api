package br.com.cce.teste.respository;

import br.com.cce.teste.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessamentoRepository extends JpaRepository<Regiao, Long> {

}
