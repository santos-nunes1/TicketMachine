package br.ticketmachine.core;

public class PapelMoeda {

    private int valor;
    private int quantidade;

    public PapelMoeda(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
