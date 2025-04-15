package fatec.poo.model;

public class Aluno extends Pessoa{
    private String ra;
    private int escolaridade;

    public Aluno(String ra, String nome) {
        super(nome);
        this.ra = ra;
    }
    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }
    public String getRa() {
        return ra;
    }
    public int getEscolaridade() {
        return escolaridade;
    }
}
