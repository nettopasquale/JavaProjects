package fatec.poo.model;

public class ContaCorrente {
    
    private int numero;
    private double saldo;
    
    public ContaCorrente(int n, double s){
        numero = n;
        saldo = s;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void sacar(double saque){
        saldo -= saque;
    }
    
    public void depositar(double deposito){
        saldo += deposito;
    }
    
}
