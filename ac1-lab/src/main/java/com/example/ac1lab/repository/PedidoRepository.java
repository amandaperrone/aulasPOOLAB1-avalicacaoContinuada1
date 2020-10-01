package com.example.ac1lab.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.ac1lab.model.Pedido;


public class PedidoRepository {
    
    private List <Pedido> pedidos;
    private int IDcodigo;

    @PostConstruct
    public void novoPedido(){
        Pedido p1 = new Pedido();
        p1.setCodigo(1);
        p1.setValor(100.50);
        p1.setDescricao("Compra de material de escritório");
        p1.setCliente("Fulano");
        p1.setDataPedido("12-11-2019");


        Pedido p2 = new Pedido();
        p2.setCodigo(2);
        p2.setValor(250.75);
        p2.setDescricao("Jogo de lençol");
        p2.setCliente("Ciclano");
        p2.setDataPedido("01-03-2020");

        Pedido p3 = new Pedido();
        p3.setCodigo(3);
        p3.setValor(899.99);
        p3.setDescricao("Cadeira Gamer");
        p3.setCliente("Beltrano");
        p3.setDataPedido("25-04-2020");

        pedidos = new ArrayList<Pedido>();
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);
        IDcodigo = 4;
        
    }

    public List<Pedido> getTodosPedidos(){
        return pedidos;
    }

    public Pedido getPedidoCodigo(int ID){
        for (int i = 0; i < pedidos.size(); i++){
            Pedido auxiliar = pedidos.get(i);
            if (ID == auxiliar.getCodigo()){
                return auxiliar;
            }
        }
        return null;
    }

    public Pedido salvarPedido (Pedido pedido){
        pedido.setCodigo(IDcodigo++);
        pedidos.add(pedido);
        return pedido;
    }

    public void removerPedido (Pedido pedido){
        pedidos.remove(pedido);
    }

    public Pedido atualizarPedido (Pedido pedido){
        Pedido auxiliar = getPedidoCodigo(pedido.getCodigo());

        if(auxiliar != null){
            auxiliar.setValor(pedido.getValor());
            auxiliar.setDescricao(pedido.getDescricao());
            auxiliar.setCliente(pedido.getCliente());
            auxiliar.setDataPedido(pedido.getDataPedido());
        }

        return auxiliar;
    }
}
