package com.kannon.aaron.magiastrpg.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Audited
public class Magia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(nullable = true)
    private Nivel nivel;
    @ManyToOne(cascade=CascadeType.PERSIST, optional = true)
    @JoinColumn(nullable = true)
    private Execucao execucao;
    @ManyToOne(cascade=CascadeType.PERSIST, optional = true)
    @JoinColumn(nullable = true)
    private Alcance alcance;
    @ManyToOne(cascade=CascadeType.PERSIST, optional = true)
    @JoinColumn(nullable = true)
    private AlvoAreaEfeito alvoAreaEfeito;
    @ManyToOne(cascade=CascadeType.PERSIST, optional = true)
    @JoinColumn(nullable = true)
    private Duracao duracao;
    @ManyToOne(cascade=CascadeType.PERSIST, optional = true)
    @JoinColumn(nullable = true)
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
