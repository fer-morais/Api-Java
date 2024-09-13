package br.com.fernanda.teste.pratico.repositorio;

import br.com.fernanda.teste.pratico.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteRepositorio extends JpaRepository<Cliente, UUID> {
    List<Cliente> findByEstado(String estado);
    List<Cliente> findByRepresentante(String representante);
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
