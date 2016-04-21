package br.ticketmachine.core;

import br.ticketmachine.exception.PapelMoedaInvalidaException;
import br.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

public class TicketMachine {

    private int valor;
    private int saldo;
    private int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) 
                achou = true;
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    private int getTroco() {
        int trocoTotal = 0;
        Troco troco = new Troco(saldo);
        Iterator<PapelMoeda> it = troco.getIterator();
        while(it.hasNext()){
        PapelMoeda papel = troco.getIterator().next();
            trocoTotal += papel.getValor();
        }
        return trocoTotal;
    }

    public String imprimir() throws SaldoInsuficienteException {
        int troco = 0;
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        if (saldo > valor){
            troco = getTroco();
            saldo=0;
        }
        if(saldo == valor){
                     
            saldo=0;
        }
        
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*** R$ " + troco + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
