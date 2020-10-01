package com.example.ac1lab.controller;

import java.net.URI;
import java.util.List;

import com.example.ac1lab.model.Pedido;
import com.example.ac1lab.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;

    @GetMapping()
    public List<Pedido> getPedidos(){
        return repository.getTodosPedidos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getPedido (@PathVariable int codigo){
        Pedido pedido = repository.getPedidoCodigo(codigo);

        if(pedido != null){
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Void> salvarPedido (@RequestBody Pedido pedido){
        pedido = repository.salvarPedido(pedido);

        URI uri = URI.create("http://localhost:8080/pedidos" + pedido.getCodigo());

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Pedido> deletarPedido (@PathVariable int codigo){
        Pedido pedido = repository.getPedidoCodigo(codigo);
        if(pedido != null){
            repository.removerPedido(pedido);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pedido> atualizarPedido (@PathVariable int codigo, @RequestBody Pedido pedido){
        if(repository.getPedidoCodigo(codigo) != null){
            pedido.setCodigo(codigo);
            pedido = repository.atualizarPedido(pedido);
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


}
