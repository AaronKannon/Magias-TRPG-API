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
public class Alcance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoAlcance;

    @Override
    public String toString() {
        return "Alcance{" +
                "id=" + id +
                ", tipoAlcance='" + tipoAlcance + '\'' +
                '}';
    }
}