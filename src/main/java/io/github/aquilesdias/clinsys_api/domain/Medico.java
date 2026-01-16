package io.github.aquilesdias.clinsys_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_medico")
public class Medico {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;
    private String email;

    public Medico(String nome, String crm, String especialidade, String email) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.email = email;
    }
}
