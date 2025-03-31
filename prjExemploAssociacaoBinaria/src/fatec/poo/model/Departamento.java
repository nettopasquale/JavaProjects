
package fatec.poo.model;

public class Departamento {
    private String sigla, nome;
    private int numFunc;
    private Funcionario funcionarios[]; 

    public Departamento(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
    
    
}
