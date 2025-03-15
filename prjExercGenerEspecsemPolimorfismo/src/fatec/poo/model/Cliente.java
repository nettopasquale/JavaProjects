
package fatec.poo.model;

public class Cliente extends Pessoa{
    private String cpf;
    private double peso, altura;
    
    public Cliente(String cpf, String n, String tel){
        super(n, tel);
        cpf = cpf;
        
    }
    
    public void setPeso(double p){
        peso = p;
    }
    
    public void setAltura(double a){
        altura = a;
    }
    
    public String getCPF(){
        return cpf;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public double getAltura(){
        return altura;
    }
    
}
