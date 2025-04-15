
package fatec.poo.model;
import java.time.Year;
import java.util.ArrayList;

public class PessoaJuridica extends Pessoa {
    private String cgc;
    private double taxaIncentivo;

    public PessoaJuridica(String cgc, String n, int anoInscr) {
        super(n, anoInscr);
        this.cgc = cgc;
    }

    @Override
    public double calcBonus(int anoInscr) {
        int anoAtual = Year.now().getValue();
        double taxaIncentivoConvertida = getTaxaIncentivo() / 100;
        return ((getTotalCompras() * taxaIncentivoConvertida) * (anoAtual - anoInscr));
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
