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
public class Medico extends Pessoa {

    private String crm, especialidade;
    private ArrayList<Consulta> consultas;

    public Medico(String cpf, String nome, String crm, String especialidade) {
        super(cpf, nome);
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void addConsulta(Consulta c) {
        consultas.add(c);
        c.setMedico(this);
    }
    
}
