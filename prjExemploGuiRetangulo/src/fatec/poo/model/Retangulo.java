package fatec.poo.model;

public class Retangulo {
    private double altura;
    private double base;
    private String unidadeMedida;

    public Retangulo(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    public void setAltura(double a){
        altura = a;
    }
    public double getAltura(){
        return(altura);
    }
    
    public void setBase(double b){
        base = b;
    }
    public double getBase(){
        return(base);
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }
    
    public double calcArea(){
        return(base * altura);
    }
    
    public double calcPerimetro(){
        return(2*(altura + base));
    }
    
    public double calcDiagonal(){
        return(Math.sqrt(Math.pow(altura, 2)+ Math.pow(base, 2)));
    }
}
