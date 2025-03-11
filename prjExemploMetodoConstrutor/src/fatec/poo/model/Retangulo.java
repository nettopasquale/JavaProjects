package fatec.poo.model;

public class Retangulo {
    private double altura;
    private double base;
        
    
    //Definição do método construtor
    public Retangulo(double a, double b){
        altura = a;
        base = b;
    }
    
    
    public void setAltura(double a){
        altura = a;
    }
    public void setBase(double b){
        base = b;
    }    
    public double getAltura(){
        return(altura);
    }    
    public double getBase(){
        return(base);        
    }    
    
    public double calcArea(){
        return(base * altura);
    }
    public double calcPerimetro(){
        return( 2 * (base + altura));
    }
    public double calcDiagonal(){
        return(Math.sqrt(Math.pow(altura,2)+ Math.pow(base,2)));
    }
}
