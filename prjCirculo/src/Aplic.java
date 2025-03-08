import fatec.poo.model.Circulo;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        // Descrição dos ponteiros dos objetos
        Scanner entrada = new Scanner(System.in);
        Circulo objCirc = new Circulo();
        
        double medRaio;
        
        System.out.println("Digite o valor de um raio: ");
        medRaio = entrada.nextDouble();
        
        objCirc.setRaio(medRaio);
        
        //Saída de dados
        System.out.println("Valor do raio: " + objCirc.getRaio());
        System.out.println("Medida da área: " + objCirc.calcArea());
        System.out.println("Medida do perimetro: " + objCirc.calcPerimetro());
        System.out.println("Medida do diametro: " + objCirc.calcDiametro());
    }
}
