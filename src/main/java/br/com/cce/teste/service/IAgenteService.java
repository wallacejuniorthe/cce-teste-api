package br.com.cce.teste.service;

import br.com.cce.teste.enumeration.TipoValorEnum;
import br.com.cce.teste.exception.ApiException;

public interface IAgenteService {
    void salvar(String conteudo) throws ApiException;
    public Double retornaValorMedioTipoRegiao(TipoValorEnum tipoValor,String sigla);
}
