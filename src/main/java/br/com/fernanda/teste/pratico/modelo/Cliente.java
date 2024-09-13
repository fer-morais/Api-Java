package br.com.fernanda.teste.pratico.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Cliente {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    private String nome;

    @Email(message = "Formato de e-mail inválido")
    private String email;
    private String cidade;
    private String estado;
    private String cep;
    private String representante;
    private Instant dataCadastro;

}
