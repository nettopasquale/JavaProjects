
package fatec.poo.model;

public abstract class Pessoa {
    
    private String nome;
    private int anoInscricao;
    private double totalCompras;
    
    public Pessoa(String n, int anoInscr){
        this.nome = n;
        this.anoInscricao = anoInscr;
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
    
}
