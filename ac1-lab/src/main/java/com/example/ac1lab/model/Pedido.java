package com.example.ac1lab.model;

public class Pedido {
    private int codigo;
    private double valor;
    private String descricao;
    private String cliente;
    private String dataPedido;


    // TO STRING, GETTERS, SETTERS
    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", codigo=" + codigo + ", dataPedido=" + dataPedido + ", descricao="
                + descricao + ", valor=" + valor + "]";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }
}
