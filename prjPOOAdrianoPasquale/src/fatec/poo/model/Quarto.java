
package fatec.poo.model;

/**
 *
 * @author Pasquale Adriano
 */
public class Quarto {
    private int numero;
    private String tipo;
    private boolean situacao;
    private double valorDiaria, totalFaturado;

    public Quarto(int numero, String tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        situacao = false;
    }
    
    public void reservar(){
        this.situacao = true;
    }
    
    public double liberar(int dias){
        double totalDiaria =0;
        totalFaturado = 0;
        
        totalDiaria = (getValorDiaria() * dias);
        totalFaturado = totalFaturado + totalDiaria;
        
        this.situacao = false;
        return totalDiaria;
    }

    public int getNumero() {
        return numero;
    }
    

    public String getTipo() {
        return tipo;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }
    
    //DELETAR ESSES SETS CASO SEJA NECESSARIO
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    
}
