package fatec.poo.model;
import java.time.Year;

public class PessoaJuridica extends Pessoa {
    private String cgc;
    private double taxaIncentivo;
    
    public PessoaJuridica(String cgc, String n, int anoIn) {
        super(n, anoIn);
        this.cgc = cgc;
    }

    @Override
    public double calcBonus(int anoIn) {
        int anoAtual = Year.now().getValue();
        return ((getTotalCompras() * this.taxaIncentivo)/100) * (anoAtual - anoIn);
    }
    
    public void setTaxaIncentivo(double txIncentivo){
        this.taxaIncentivo = txIncentivo;
    }
    
    public String getCGC(){
        return this.cgc;
    }
    
    public double getTaxaIncentivo(){
        return this.taxaIncentivo;
    }
    
}
