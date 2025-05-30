
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Pasquale Adriano
 */
public class Hospede extends Pessoa{
    private String cpf;
    private double taxaDesconto;
    private ArrayList<Registro> registros;// ponteiro multiplicidade 1..*
    
    public Hospede(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
        registros = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }
    
    public void addRegistro(Registro registro){
        registros.add(registro);
    }
    
    public boolean validarCPF(String cpf){
        //implementar aqui validação de cpf
        int soma = 0;
        int digito1, digito2, peso;
        // retira os caracteres desnecessarios de cpf
        cpf = cpf.replace(".","").replace("-","");

        // verifica se cpf tem todos numeros iguais e se tem tamanho
        // menor que 11 caracteres;
        if(cpf.contains("00000000000")|| cpf.contains("11111111111") 
                || cpf.contains("22222222222") || cpf.contains("33333333333") 
                || cpf.contains("44444444444") || cpf.contains("55555555555") 
                || cpf.contains("66666666666") || cpf.contains("77777777777") 
                || cpf.contains("88888888888") || cpf.contains("99999999999") 
                || cpf.length() != 11){
            return false;
        }
        
        //calculo de verificação se cpf é válido
        //calculo do 1º digito:
        peso =10;
        for(int i =0; i < 9; i++){
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * peso;
            peso--;
            System.out.println(soma+"\n");
        }
        System.out.println("Soma total: " + soma);
        
        digito1 = 11 - (soma % 11);
        
        if(digito1 > 9) digito1 = 0;
        
        System.out.println("Digito 1: " + digito1);
        
        //calculo 2º digito
        soma = 0;
        peso = 11;
        
        for(int i = 0; i < 10; i++){
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * peso;
            peso--;
            System.out.println(soma+"\n");
        }
        System.out.println("A soma atual do 2º eh: "+ soma);
        
        digito2 = 11 - (soma % 11);
        
        if(digito2 > 9) digito2 = 0;
        
        System.out.println("Digito 2: " + digito2);
        
        //retorno da verificação
        return (digito1 == Character.getNumericValue(cpf.charAt(9)) 
                && digito2 == Character.getNumericValue(cpf.charAt(10)));
    }

}
