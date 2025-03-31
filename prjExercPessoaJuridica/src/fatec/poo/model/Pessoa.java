
package fatec.poo.model;

public abstract class Pessoa {
    private String nome;
    private int anoInscricao;
    private double totalCompras;
    
    public Pessoa(String n, int anoIn){
        this.nome = n;
        this.anoInscricao = anoIn;
    }
    
    abstract public double calcBonus(int v );
    
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
}
