
package fatec.poo.model;
public abstract class Pessoa {
    
    private String nome;
    private int anoInscricao, numCad;
    private double totalCompras;
    private PedidoCompra[] cadPedidos;
    
    public Pessoa(String n, int anoInscr){
        this.nome = n;
        this.anoInscricao = anoInscr;
        cadPedidos = new PedidoCompra[11];
        numCad = 0;
    }
    
    public abstract double calcBonus(int anoInscr);
    
    public void addCompras(PedidoCompra caP){
        cadPedidos[numCad++] = caP;
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
    
}
