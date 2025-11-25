/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.model;

/**
 *
 * @author Pasquale
 */
public class Pessoa {

    private String cpf, nome, endereco, telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public static boolean validarCPF(String cpf) {
        String cpfNumeros = cpf.replaceAll("[^0-9]", "");
        if (cpfNumeros.length() != 11) {
            return false;
        }

        // verificando se são todos iguais, ex: 111.111.111-11, 222.222.222-22, etc...
        if (cpfNumeros.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(String.valueOf(cpfNumeros.charAt(i)));
        }

        // constituindo primeiro DV
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += digitos[i] * (10 - i);
        }
        int resto1 = soma1 % 11;
        int dv1Calculado = (resto1 < 2) ? 0 : (11 - resto1);

        // apos calculado primeiro DV é hora de verificar com o recebido
        if (dv1Calculado != digitos[9]) {
            return false;
        }

        // constituindo segundo DV
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += digitos[i] * (11 - i); // Multiplicadores de 11 a 2
        }
        int resto2 = soma2 % 11;
        int dv2Calculado = (resto2 < 2) ? 0 : (11 - resto2);

        //apos calculado segundo DV é hora de verificar com o recebido
        if (dv2Calculado != digitos[10]) {
            return false;
        }

        // se nenhum return false for acionado então:
        return true;

    }

}
