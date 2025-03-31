package fatec.poo.model;

public abstract class Funcionario {
     private int registro;
    private String nome, dtAdmissao, cargo;
    
    public Funcionario(int r, String n, String dtAdm){
        this.registro = r;
        this.nome = n;
        this.dtAdmissao = dtAdm;
    }
    
    //método abstrato
    //apresenta apenas assinatura
    abstract public double calcSalBruto();
    
    public double calcDesconto(){
        return (0.1 * calcSalBruto());
    }
    
    public double calcSalLiquido(){
        return (calcSalBruto() - calcDesconto());
    }
    
    public int getRegistro(){
        return registro;
    }
    public String getNome(){
        return nome;
    }
    public String getAdmss(){
        return dtAdmissao;
    }
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String c){
        cargo = c;
    }
    
}
