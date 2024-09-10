package br.com.fernanda.teste.pratico.controller;

import br.com.fernanda.teste.pratico.modelo.Cliente;
import br.com.fernanda.teste.pratico.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

      /* Todas as requisições foram testadas no Postman  ---- conferir "clientes.postman_collection.json" ---- */

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    //Listar os clientes
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepositorio.findAll();
    }

    //Incluir clientes em Json
    @PostMapping
    public void incluir(@RequestBody Cliente cliente){
        clienteRepositorio.save(cliente);
    }

    //Alterar clientes
    //Posso alterar todos os campos menos o id, que ele salva um novo cliente
    @PutMapping
    public void alterar(@RequestBody Cliente cliente){
        clienteRepositorio.save(cliente);

    }

    //Deletar cliente pelo id
    @DeleteMapping ("/{id}")
    public void deletar(@PathVariable Long id){
        clienteRepositorio.deleteById(id);

    }

     //Ler cliente pelo id
     @GetMapping("/{id}")
     public Optional<Cliente> ler(@PathVariable Long id){
        return clienteRepositorio.findById(id);
     }
}
