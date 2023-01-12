package br.com.cce.teste.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TAB_REGIAO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGENTE_ID")
    private Agente agente;

    @Column(nullable = false)
    private String sigla;
}
