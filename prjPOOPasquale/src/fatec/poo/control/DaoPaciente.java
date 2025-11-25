/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Pasquale
 */
public class DaoPaciente {

    private Connection conn;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DaoPaciente(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Paciente paciente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tbPaciente (Cpf_Paciente, Nome_Paciente, Endereco_Paciente, Telefone_Paciente, DataNascimento_Paciente, Altura_Paciente, Peso_Paciente) VALUES (?,?,?,?,?,?,?)");

            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getEndereco());
            ps.setString(4, paciente.getTelefone());
            ps.setDate(5, java.sql.Date.valueOf(LocalDate.parse(paciente.getDataNascimento(), formatter)));
            ps.setDouble(6, paciente.getAltura());
            ps.setDouble(7, paciente.getPeso());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                };
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public void alterar(Paciente paciente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tbPaciente SET Nome_Paciente = ?, Endereco_Paciente = ?, Telefone_Paciente = ?, DataNascimento_Paciente = ?, Altura_Paciente = ?, Peso_Paciente = ? WHERE Cpf_Paciente = ?");

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEndereco());
            ps.setString(3, paciente.getTelefone());
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.parse(paciente.getDataNascimento(), formatter)));
            ps.setDouble(5, paciente.getAltura());
            ps.setDouble(6, paciente.getPeso());
            ps.setString(7, paciente.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public Paciente consultar(String cpf) {
        Paciente paciente = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tbPaciente WHERE Cpf_Paciente = ?");
            ps.setString(1, cpf);
            rs = ps.executeQuery();

            if (rs.next()) {
                paciente = new Paciente(rs.getString("Cpf_Paciente"), rs.getString("Nome_Paciente"), rs.getDate("DataNascimento_Paciente").toLocalDate());
                paciente.setEndereco(rs.getString("Endereco_Paciente"));
                paciente.setTelefone(rs.getString("Telefone_Paciente"));
                paciente.setAltura(rs.getDouble("Altura_Paciente"));
                paciente.setPeso(rs.getDouble("Peso_Paciente"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return paciente;
    }

    public void excluir(Paciente paciente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM tbPaciente WHERE Cpf_Paciente = ?");

            ps.setString(1, paciente.getCpf());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

}
