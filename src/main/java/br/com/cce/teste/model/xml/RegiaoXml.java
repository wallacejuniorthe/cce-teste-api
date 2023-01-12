package br.com.cce.teste.model.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("regiao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegiaoXml {
    private String sigla;
    private List<ItemXml> itens = new ArrayList<ItemXml>();

}
