package br.com.cce.teste.respository;

import br.com.cce.teste.enumeration.TipoValorEnum;
import br.com.cce.teste.model.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ValorRepository extends JpaRepository<Valor, Long> {

    @Query(value = "select v from Valor v where v.tipoValor=:tipoValor and v.regiao.sigla=:sigla")
    List<Valor> findValoresTipoRegiao(@Param("tipoValor") TipoValorEnum tipoValor,
                                      @Param("sigla") String sigla);



}
