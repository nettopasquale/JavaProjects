
package fatec.poo.model;
import java.util.ArrayList;

public abstract class Pessoa {
    
    private String nome;
    private int anoInscricao, numPed;
    private double totalCompras;
    private ArrayList<PedidoCompra> cadCompras;
    
    public Pessoa(String n, int anoInscr){
        this.nome = n;
        this.anoInscricao = anoInscr;
        cadCompras = new ArrayList<>();
    }
    
    public abstract double calcBonus(int anoInscr);
    
    public void addCompras(double c){
        this.totalCompras += c;
        
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getAnoInscricao(){
        return this.anoInscricao;
    }
    public double getTotalCompras(){
        return this.totalCompras;
    }
    
    public void addPedidoCompras(PedidoCompra pC){
        cadCompras.add(pC);
    }
    
    
    
}
