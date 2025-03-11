import fatec.poo.model.ContaCorrente;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero, opcao;
        double saldo, saque, deposito;
        
        System.out.println("Digite o numero da sua conta: ");
        numero = entrada.nextInt();
        
        System.out.println("Digite seu saldo: ");
        saldo = entrada.nextDouble();
        
        ContaCorrente contaCorrente = new ContaCorrente(numero, saldo);
        
        do{
            System.out.println("Digite uma das opções abaixo: \n");
            System.out.println("1 - Depositar ");
            System.out.println("2 - Sacar ");
            System.out.println("3 - Consultar Saldo ");
            System.out.println("4 - Sair ");
            
            opcao = entrada.nextInt();
            
            switch(opcao){
                case 1: 
                    System.out.println("\n\n Número da conta corrente: " + contaCorrente.getNumero());
                    System.out.println("Digite um valor para ser depositado: " );
                    contaCorrente.depositar(deposito = entrada.nextDouble());
                    System.out.println("Valor depositado com sucesso!");
                    break;
                    
                case 2: 
                    System.out.println("\n\n Número da conta corrente: " + contaCorrente.getNumero());
                    System.out.println("Digite um valor para ser sacado: " );
                    saque = entrada.nextDouble();
                    
                    if(saque > contaCorrente.getSaldo()){
                        System.out.println("Saldo Insuficiente!" );
                    }
                    else{
                        contaCorrente.sacar(saque);
                    }
                    System.out.println("Valor sacado com sucesso!");
                    break;
                    
                    case 3: 
                    System.out.println("\n\n Número da conta corrente: " + contaCorrente.getNumero());
                    System.out.println("Saldo disponível: " + contaCorrente.getSaldo());
                    break;
            }
            
        } while(opcao < 4);
        
    }
    
}
