package fatec.poo.model;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private String regfunc;
    private int titularidade;
    private int areaAtuacao; 
    private ArrayList<Turma> turmas;

    public Professor(String regfunc, String nome) {
        super(nome);
        this.regfunc = regfunc;
        turmas = new ArrayList<>();
    }
    public void setTitularidade(int titularidade) {
        this.titularidade = titularidade;
    }
    public void setAreaAtuacao(int areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    public String getRegfunc() {
        return regfunc;
    }
    public int getTitularidade() {
        return titularidade;
    }
    public int getAreaAtuacao() {
        return areaAtuacao;
    }
    public void addTurma(Turma t) {
        turmas.add(t);
    } 
}
