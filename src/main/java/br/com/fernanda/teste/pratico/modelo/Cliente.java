package br.com.fernanda.teste.pratico.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor // sem argumentos
@AllArgsConstructor // todos os argumentos
@Entity
@Data // getters e setters e toString
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String email;
    private String cidade;
    private String estado;
    private String cep;
    private String representante;
    private Instant dataCadastro;

}
