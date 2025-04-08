
package fatec.poo.model;
public abstract class Pessoa {
    
    private String nome;
    private int anoInscricao, numPed;
    private double totalCompras;
    private PedidoCompra[] cadPedidos;
    
    public Pessoa(String n, int anoInscr){
        this.nome = n;
        this.anoInscricao = anoInscr;
        cadPedidos = new PedidoCompra[10];
        numPed = 0;
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
    
    public void addPedidos(PedidoCompra pc){
        cadPedidos[numPed] = pc;
    }
    
    
    
}
