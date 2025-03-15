import fatec.poo.model.Cliente;
import fatec.poo.model.Instrutor;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int id;
        //devo usar só uma variavel nome e tel?
        //String nome_Instrutor, nome_Cliente, cpf,tel_Instrutor, tel_Cliente;
        String nome, cpf,tel;
        //double peso, altura;
        
        System.out.println("Instrutor, digite seu numero de identificacao: ");
        id = entrada.nextInt();
        
        System.out.println("Instrutor, digite seu nome: ");
        nome= entrada.next();
        
        System.out.println("Instrutor, digite seu numero de telefone: ");
        tel = entrada.next();
        
        
        //Instanciacao Instrutor
        Instrutor objInstrutor = new Instrutor(id, nome, tel);
        
        // ESSA AREA PODE MUDAR! Professor não pediu isso
        System.out.println("Instrutor, digite sua area de atuacao: ");
        objInstrutor.setAreaAtuacao(entrada.next());
        
        
        
        System.out.println("Cliente, digite seu numero de cpf: ");
        cpf = entrada.next();
        
        System.out.println("Cliente, digite seu nome: ");
        nome = entrada.next();
        
        System.out.println("Cliente, digite seu numero de telefone: ");
        tel = entrada.next();
        
        //Instanciacao Cliente
        Cliente objCliente = new Cliente(cpf, nome, tel);
        
        // ESSA AREA PODE MUDAR! Professor não pediu isso
        System.out.println("Cliente, digite seu peso: ");
        objCliente.setPeso(entrada.nextDouble());
        
        System.out.println("Cliente, digite sua altura: ");
        objCliente.setAltura(entrada.nextDouble());
        
        //Mensagens

        System.out.println("Instrutor, sua identificacao eh: " + objInstrutor.getIdentificacao());
        System.out.println("Instrutor, seu nome eh: " + objInstrutor.getNome());
        System.out.println("Instrutor, seu telefone eh: " + objInstrutor.getTelefone());
        //MENSAGEM AQUI OPCIONAL!
        System.out.println("Instrutor, sua area de atuacao eh: " + objInstrutor.getAreaAtuacao());
        System.out.println();
        System.out.println("Cliente, sua identificacao eh: " + objCliente.getCPF());
        System.out.println("Cliente, seu nome eh: " + objCliente.getNome());
        System.out.println("Cliente, seu telefone eh: " + objCliente.getTelefone());
        //MENSAGEM AQUI OPCIONAL!
        System.out.println("Cliente, sua peso eh: " + objCliente.getPeso());
        System.out.println("Cliente, sua altura eh: " + objCliente.getAltura());        
        
    }
    
}
