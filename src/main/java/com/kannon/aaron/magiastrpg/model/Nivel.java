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
public class Nivel {
    //Nivel - Tabela Separada - id, arcano [boolean], divino [boolean], nível
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean arcano;
    private boolean divino;
    @OneToOne(cascade=CascadeType.PERSIST )
    private Escola escola;
    private int valorNivel;
}
