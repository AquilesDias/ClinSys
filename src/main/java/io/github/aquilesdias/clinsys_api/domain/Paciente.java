package io.github.aquilesdias.clinsys_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_paciente")
public class Paciente {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dtNascimento;
    private String telefone;
    private String endereco;

    public Paciente(String nome, String cpf, LocalDate dtNascimento, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
