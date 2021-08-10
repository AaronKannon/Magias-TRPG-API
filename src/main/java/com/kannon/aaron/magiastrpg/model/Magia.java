package com.kannon.aaron.magiastrpg.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Magia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne(cascade=CascadeType.PERSIST )
    private Nivel nivel;
    @OneToOne(cascade=CascadeType.PERSIST, optional = true)
    private Execucao execucao;
    @OneToOne(cascade=CascadeType.PERSIST, optional = true)
    private Alcance alcance;
    @OneToOne(cascade=CascadeType.PERSIST, optional = true)
    private AlvoAreaEfeito alvoAreaEfeito;
    @OneToOne(cascade=CascadeType.PERSIST, optional = true)
    private Duracao duracao;
    @OneToOne(cascade=CascadeType.PERSIST, optional = true)
    private Resistencia resistencia;
    private String fonte;
    @Column(columnDefinition="TEXT",length = 2500)
    private String descricao;
    /*id
    Nivel - Tabela Separada - id, arcano [boolean], divino [boolean], nível
    Escola - Tabela Separada - id, Escola
    Tempo de Execução (Pode ser nulo) - Tabela Separada - id, Tipo
    Alcance (Pode ser nulo)
    Alvo (Pode ser nulo)
    Área (Pode ser nulo)
    Duração (Pode ser nulo)
    Efeito (Pode ser nulo)
    Teste de Resistencia (Pode ser nulo)
    Descricão
    Componente material (Pode ser nulo)*/
}
