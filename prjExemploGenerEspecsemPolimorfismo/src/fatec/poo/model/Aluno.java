package fatec.poo.model;
//Definição do vínculo de herança(extends) entre
//a classe Aluno(subclasse) e a classe Pessoa(superclasse) 

public class Aluno extends Pessoa{ 
    private int regEscolar;
    private double mensalidade;

    //constructor
    public Aluno(int re, String n, String dn) {
        super(n, dn);//chamada do método construtor
                     //da super classe
        regEscolar = re;
    }

    public void setMensalidade(double m) {
        mensalidade = m;
    }
    public int getRegEscolar() {
        return regEscolar;
    }

    public double getMensalidade() {
        return mensalidade;
    }
}
