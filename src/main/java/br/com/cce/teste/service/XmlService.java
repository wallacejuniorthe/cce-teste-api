package br.com.cce.teste.service;

import br.com.cce.teste.model.xml.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class XmlService implements IXmlService{
    private XStream getXStreamConfig(){
        XStream xstream = new XStream();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("agentes", List.class);

        xstream.alias("agente", AgenteXml.class);
        xstream.addImplicitCollection(AgenteXml.class, "regioes");

        xstream.alias("regiao", RegiaoXml.class);
        xstream.useAttributeFor(RegiaoXml.class, "sigla");
        xstream.addImplicitCollection(RegiaoXml.class, "itens");

        xstream.alias("geracao", GeracaoXml.class);
        xstream.addImplicitCollection( GeracaoXml.class, "valores", "valor", Double.class);

        xstream.alias("compra", CompraXml.class);
        xstream.addImplicitCollection( CompraXml.class, "valores", "valor", Double.class);

        xstream.alias("precoMedio", PrecoMedioXml.class);
        xstream.addImplicitCollection( PrecoMedioXml.class, "valores", "valor", Double.class);

        xstream.addPermission(AnyTypePermission.ANY);

        return  xstream;
    }

    public List<AgenteXml> listaFromXml(String conteudo) {
        XStream xstream = getXStreamConfig();
        try {
            return  (List<AgenteXml>)xstream.fromXML(conteudo);
        } catch (Exception ex){
            return null;
        }
    }
}
