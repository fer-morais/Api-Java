package br.com.fernanda.teste.pratico.repositorio;

import br.com.fernanda.teste.pratico.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio  extends JpaRepository<Cliente, Long> {
}
