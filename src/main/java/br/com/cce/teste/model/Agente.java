package br.com.cce.teste.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TAB_AGENTE")
@NoArgsConstructor
@AllArgsConstructor
@Data
@XStreamAlias("agente")
public class Agente {

    @Id
    private Long codigo;

    @Column(nullable = false)
    private LocalDateTime data;
}
