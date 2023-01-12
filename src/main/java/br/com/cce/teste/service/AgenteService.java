package br.com.cce.teste.service;

import br.com.cce.teste.enumeration.TipoValorEnum;
import br.com.cce.teste.exception.ApiException;
import br.com.cce.teste.model.Agente;
import br.com.cce.teste.model.Regiao;
import br.com.cce.teste.model.Valor;
import br.com.cce.teste.model.xml.*;
import br.com.cce.teste.respository.AgenteRepository;
import br.com.cce.teste.respository.ProcessamentoRepository;
import br.com.cce.teste.respository.ValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AgenteService implements IAgenteService{

    @Autowired
    AgenteRepository agenteRepository;

    @Autowired
    ProcessamentoRepository processamentoRepository;

    @Autowired
    ValorRepository valorRepository;

    @Autowired
    IXmlService xmlService;

    @Override
    @Transactional
    public void salvar(String conteudo) throws ApiException {

        System.out.println("**************************************************");
        System.out.println("Códigos dos agentes recebidos:");

        try {
            List<AgenteXml> lista = xmlService.listaFromXml(conteudo);
            for (AgenteXml agenteXml:lista) {
                LocalDateTime data = LocalDateTime.parse(agenteXml.getData(), DateTimeFormatter.ISO_DATE_TIME);
                Agente agente = new Agente(agenteXml.getCodigo(), data);
                agenteRepository.save(agente);
                System.out.println(String.format("Agente recebido: %d",agenteXml.getCodigo()));

                for (RegiaoXml regiaoXml: agenteXml.getRegioes()) {
                    Regiao regiao = new Regiao();
                    regiao.setAgente(agente);
                    regiao.setSigla(regiaoXml.getSigla());
                    processamentoRepository.save(regiao);

                    for (ItemXml itemXml: regiaoXml.getItens()) {
                        if (!(itemXml instanceof PrecoMedioXml)) {
                            for (Double valorXml : itemXml.getValores()) {
                                Valor valor = new Valor();
                                valor.setRegiao(regiao);
                                valor.setValor(valorXml);
                                if (itemXml instanceof GeracaoXml) {
                                    valor.setTipoValor(TipoValorEnum.GERACAO);
                                } else if (itemXml instanceof CompraXml) {
                                    valor.setTipoValor(TipoValorEnum.COMPRA);
                                }
                                valorRepository.save(valor);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex){
            throw new ApiException("Erro ao processar arquivo XML");
        }
    }
    public Double retornaValorMedioTipoRegiao(TipoValorEnum tipoValor,String sigla){
        List<Valor> lista = valorRepository.findValoresTipoRegiao(tipoValor,sigla.toUpperCase());
        Double media = lista.stream().map(x->x.getValor()).collect(Collectors.averagingDouble(num->num));
        return media;
    }
}
