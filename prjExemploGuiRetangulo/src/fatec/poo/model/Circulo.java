
package fatec.poo.model;

public class Circulo {
    private double raio;
    private String unidadeMedida;

    public Circulo(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    public void setRaio(double r){
        raio = r;
    }
    
    public double getRaio(){
        return raio;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String uM) {
        this.unidadeMedida = uM;
    }
    
    
    public double calcArea(){
        return (Math.PI * Math.pow(raio, 2));
    }
    
    public double calcPerimetro(){
        return (2 * (Math.PI * raio));
    }
    
    public double calcDiametro(){
        return (2 * raio);
    }
    
}
