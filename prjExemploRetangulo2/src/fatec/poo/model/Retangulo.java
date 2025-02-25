
package fatec.poo.model;

public class Retangulo {
    private double altura, base;
    
    public void setAltura(double a){
        altura = a;
    }
    public void setBase(double b){
        base = b;
    }
    public double getAltura(){
        return altura;
    }
    public double getBase(){
        return base;
    }
    
    public double calcArea(){
        return (altura * base);
    }
    
    public double calcPer(){
        return 2*(altura + base);
    }
    
    public double calcDiag(){
        return Math.sqrt((Math.pow(altura, 2) + Math.pow(base, 2)));
    }
}
