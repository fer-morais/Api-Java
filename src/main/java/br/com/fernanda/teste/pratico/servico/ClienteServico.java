package br.com.fernanda.teste.pratico.servico;

import br.com.fernanda.teste.pratico.exception.ClienteNaoEncontradoException;
import br.com.fernanda.teste.pratico.modelo.Cliente;
import br.com.fernanda.teste.pratico.repositorio.ClienteRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ClienteServico {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente getCliente(UUID id) {
        return clienteRepositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado " + id));
    }

    public List<Cliente> listar() {
        return clienteRepositorio.findAll();
    }

    public void deletar(UUID id) {
        clienteRepositorio.deleteById(id);
    }

    public void incluir(Cliente cliente) {
        cliente.setDataCadastro(Instant.now());
        clienteRepositorio.save(cliente);
    }

    public void alterar(Cliente cliente) {
        Cliente clienteExistente = getCliente(cliente.getId());
        BeanUtils.copyProperties(cliente, clienteExistente, "id", "dataCadastro");
        clienteRepositorio.save(clienteExistente);
    }

    public List<Cliente> listarPorEstado(String estado) {
        return clienteRepositorio.findByEstado(estado);
    }

    public List<Cliente> listarPorRepresentante(String representante) {
        return clienteRepositorio.findByRepresentante(representante);
    }

    public List<Cliente> pesquisarPorNome(String nome) {
        return clienteRepositorio.findByNomeContainingIgnoreCase(nome);
    }
}
