package io.github.leonardogit.rest.controller;

import io.github.leonardogit.domain.entity.Cliente;
import io.github.leonardogit.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/all")
    @ResponseBody //Maneira correta para implementação seria diratamente pelo Service
    public List<Cliente> findAll(){
            return clientes.findAll();
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById( @PathVariable Integer id ){
        Optional<Cliente> cliente = clientes.findById(id);
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente){
        Cliente clienteSave = clientes.save(cliente);
        return ResponseEntity.ok(clienteSave);
    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Cliente> clienteDelete = clientes.findById(id);
        if (clienteDelete.isPresent()){
            clientes.delete(clienteDelete.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping ("api/clientes/{id}")//Atualizar integralmente recurso no servidor , caso enviar algum propriedade nula deve ser att sem os dados nulos
    @ResponseBody
    public ResponseEntity update( @PathVariable Integer id ,
                                  @RequestBody Cliente cliente ){
        return clientes
                .findById(id)
                .map( clienteExistente -> {
                   cliente.setId(clienteExistente.getId());//map = se existir algum resultado ele irá executar comando , método map sempre deve retornar um objeto
                   clientes.save(cliente);
                   return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build());
    }

}
