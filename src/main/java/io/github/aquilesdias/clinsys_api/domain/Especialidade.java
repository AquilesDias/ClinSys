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
@Table(name = "tbl_especialidade")
public class Especialidade {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String descricao;

    public Especialidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
