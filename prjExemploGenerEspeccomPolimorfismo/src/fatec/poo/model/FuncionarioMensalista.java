
package fatec.poo.model;

public class FuncionarioMensalista extends Funcionario {
    private double valSalMin, numSalMin;

    public FuncionarioMensalista(int r, String n, String dtAdm, String c,  double vsm) {
        super(r, n, dtAdm, c);
        this.valSalMin = vsm;
    }

    @Override
    public double calcSalBruto() {
        return (valSalMin * numSalMin);
    }
    
    public void setNumSalMin(double nsm){
        numSalMin = nsm;
    }
    
}
