package fatec.poo.model;

abstract public class Funcionario {
    private int registro;
    private String nome;
    private String dtAdmissao;  
    private String cargo;
    private Departamento departamento; //definicao ponteiro - multiplicidade 1
    private Projeto projeto; //definicao ponteiro - multiplicidade 1
    
    public Funcionario(int r, String n, String dtAdm){
        registro = r;
        nome = n;
        dtAdmissao = dtAdm;  
    }   
    
    public int getRegistro(){
        return(registro);
    }
    public String getNome(){
        return(nome);
    }
    public String getDtAdmissao(){
        return(dtAdmissao);
    }
    public String getCargo(){
        return(cargo);
    }
    public void setCargo(String c){
        cargo = c;
    }

    //tem como retorno o endereço de um objeto da classe depto
    public Departamento getDepartamento() {
        return departamento;
    }

    //tem como parametro de entrada o endereço de um objeto da classe depto
    public void setDepartamento(Departamento d) {
        departamento = d;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto p) {
        this.projeto = p;
    }
    
    public abstract double calcSalBruto();
    
    public double calcDesconto(){
        return(0.10 * calcSalBruto());
    }
    public double calcSalLiquido(){
        return(calcSalBruto() - calcDesconto());
    }
    
}
