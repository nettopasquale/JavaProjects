/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class Consulta {

    private int codigo;
    private String data, cpfPaciente;
    private double valor;
    private Medico medico;
    private ArrayList<Medicacao> medicacoes;
    private ArrayList<Exame> exames;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        this.medicacoes = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    

    public double getValor() {
        return valor;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }
    

    public void setMedico(Medico m) {
        this.medico = m;
    }

    public Medico getMedico() {
        return this.medico;
    }
    

    public ArrayList<Medicacao> getMedicacoes() {
        return medicacoes;
    }

    public void addMedicacoes(Medicacao m) {
        medicacoes.add(m);
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public void addExames(Exame e) {
        exames.add(e);
        e.setConsulta(this);
    }

    public double calcValorTotalPagar() {
        //exames!
        double valorFinal = valor;

        for (int i = 0; i < exames.size(); i++) {
            valorFinal += exames.get(i).getValor();
        }

        return valorFinal;
    }
}
