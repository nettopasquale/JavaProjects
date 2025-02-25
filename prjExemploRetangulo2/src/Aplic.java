import fatec.poo.model.Retangulo;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        // Ponteiro para Scanner
        Scanner entrada = new Scanner(System.in);
        Retangulo objRet = new Retangulo();
        double medAlt, medBase;
        
        System.out.println("Digite a medida da altura: ");
        medAlt = entrada.nextDouble(); // pega entrada double
        
        System.out.println("Digite a medida da base: ");
        medBase = entrada.nextDouble(); //
        
        objRet.setAltura(medAlt);
        objRet.setBase(medBase);
        
        System.out.println("A medida da altura é: " + objRet.getAltura());
        System.out.println("A medida da base é: " + objRet.getBase());
        System.out.println("A medida da área é: " + objRet.calcArea());
        System.out.println("A medida do perimetro é: " + objRet.calcPer());
        System.out.println("A medida da diagonal é: " + objRet.calcDiag());
        
        
    }
    
}
