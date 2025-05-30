
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
        //getCpf().trim();
        return true;
    }

}
