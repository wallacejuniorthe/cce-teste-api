package br.com.cce.teste.model;

import br.com.cce.teste.enumeration.TipoValorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TAB_VALORES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Valor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "REGIAO_ID")
    private Regiao regiao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoValorEnum tipoValor;
}
