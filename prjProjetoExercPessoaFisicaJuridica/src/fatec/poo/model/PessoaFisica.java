
package fatec.poo.model;

import java.time.Year;

public class PessoaFisica extends Pessoa{
    private String cpf;
    private double base;

    public PessoaFisica(String cpf, String n, int anoInscr) {
        super(n, anoInscr);
        this.cpf = cpf;
    }

    @Override
    public double calcBonus(int anoInscr) {
        if(getTotalCompras() > 12000){
            int anoAtual = Year.now().getValue();
            return ((anoAtual - anoInscr) * getBase());
        }
        else{
            return 0;
        }
    }
    
    public String getCPF(){
        return this.cpf;
    }
    
    public void setBase(double salBase){
        this.base = salBase;
    }
    
    public double getBase(){
        return this.base;
    }
}
