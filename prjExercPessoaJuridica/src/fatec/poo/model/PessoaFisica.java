package fatec.poo.model;
import java.time.Year;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private double base;

    public PessoaFisica(String cpf, String n, int anoIn) {
        super(n, anoIn);
        this.cpf = cpf;
    }

    @Override
    public double calcBonus(int anoIn) {
        if(getTotalCompras()> 12000){
            int anoAtu = Year.now().getValue();
            return (anoAtu - anoIn) * this.base;
        }
        else
            return 0;
    }
    
    public String getCPF(){
        return this.cpf;
    }
    
    public void setBase(double b){
        this.base = b;
    }

    public double getBase(){
        return this.base;
    }
    
}
