package br.ticketmachine.exception;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException() {
        super("Falta de Saldo");
    }
    
}
