package br.com.fernanda.teste.pratico.controller;

import br.com.fernanda.teste.pratico.modelo.Cliente;
import br.com.fernanda.teste.pratico.repositorio.ClienteRepositorio;
import br.com.fernanda.teste.pratico.servico.ClienteServico;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteServico clienteServico;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public ClienteController(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteServico.listar();
    }

    @PostMapping
    public void incluir(@Valid @RequestBody Cliente cliente) {
        clienteServico.incluir(cliente);
    }

    @PutMapping
    public void alterar(@Valid @RequestBody Cliente cliente) {
        clienteServico.alterar(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") UUID id) {
        clienteServico.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Cliente ler(@PathVariable UUID id) {
        return clienteServico.getCliente(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Cliente> listarPorEstado(@PathVariable String estado) {
        return clienteServico.listarPorEstado(estado);
    }

    @GetMapping("/representante/{representante}")
    public List<Cliente> listarPorRepresentante(@PathVariable String representante) {
        return clienteServico.listarPorRepresentante(representante);
    }

    @GetMapping("/pesquisa/{nome}")
    public List<Cliente> pesquisarPorNome(@PathVariable String nome) {
        return clienteServico.pesquisarPorNome(nome);
    }
}
