
package fatec.poo.model;

public class PedidoCompra {
    private int numero;
    private String dataPedido;
    private double valor;
    private Pessoa pessoa;

    public PedidoCompra(int n) {
        this.numero = n;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dtP) {
        this.dataPedido = dtP;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double v) {
        this.valor = v;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
