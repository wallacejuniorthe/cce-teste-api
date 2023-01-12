package br.com.cce.teste.service;

import br.com.cce.teste.model.xml.AgenteXml;

import java.util.List;

public interface IXmlService {
    List<AgenteXml> listaFromXml(String conteudo);
}
