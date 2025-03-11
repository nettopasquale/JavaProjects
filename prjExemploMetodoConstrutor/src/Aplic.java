import java.util.Scanner;

/**
 *
 * @author Dimas
 */
public class Aplic {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        double medAlt, medBase;
        int opcao;
        String unidade; 
        
        System.out.print("Digite a unidade de medida: ");
        unidade = entrada.next();
        
        //criação do ponteiro,
        //instanciação(alocação) de um objeto da classe Retangulo
        //e chamada do método construtor
        
        
        
        System.out.print("Digite a medida da altura: ");
        medAlt = entrada.nextDouble();
        System.out.print("Digite a medida da base: ");
        medBase = entrada.nextDouble();
        
        //Passagem de mensagens
        //passagem de mensagens
        objRet.setAltura(medAlt);
        objRet.setBase(medBase);
       
        System.out.println("Medida da altura: " + objRet.getAltura());
        System.out.println("Medida da base: " + objRet.getBase());
        System.out.println("Medida da área: " + objRet.calcArea());
        System.out.println("Medida do perímetro: " + objRet.calcPerimetro());
        System.out.println("Medida da diagonal: " + objRet.calcDiagonal());
    }    
}
