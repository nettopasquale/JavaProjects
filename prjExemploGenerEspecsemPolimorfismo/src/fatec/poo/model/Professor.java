
package fatec.poo.model;

public class Professor extends Pessoa {
    private int regFuncional;
    private double salario;
    
    public Professor(int re, String n, String dn){
        super(n, dn);
        regFuncional = re;
        
    }
    
    public void setSalario(double s){
        salario = s;
    }
    
    public double getSalario(){
        return salario;
    }
    
    public int getRegFuncional(){
    
        return regFuncional;
    }
}
