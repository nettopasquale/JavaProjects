/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class Paciente extends Pessoa {

    private LocalDate dataNascimento;
    private double altura, peso;
    private ArrayList<Consulta> consultas;

    public Paciente(String cpf, String nome, LocalDate dt) {
        super(cpf, nome);
        dataNascimento = dt;
        this.consultas = new ArrayList<>();
    }

    public String getDataNascimento() {
        // formatar em dd/mm/aaaa
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatter);
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }
    
    public void addConsultas(Consulta c){
        consultas.add(c);
    }
    
    public double calcIMC(){
        double imc;
        
        imc = Math.round(peso/(Math.pow(altura, 2)));
        return imc;
    }
    
    public int calcIdade(LocalDate hj){
        hj = LocalDate.now();
        int idade;
        
        Period periodo = Period.between(dataNascimento, hj);
        idade = Math.abs(periodo.getYears());
        return idade;
    }

}
