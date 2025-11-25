/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pasquale
 */
public class DaoConsulta {

    private Connection conn;

    public DaoConsulta(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Consulta consulta, String cpf) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tbConsulta(Codigo_Consulta, CPFMedico_Consulta, CPFPaciente_Consulta, Data_Consulta, Valor_Consulta) VALUES(?,?,?,?,?)");

            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getMedico().getCpf());
            ps.setString(3, cpf.replace("[^0-9]", ""));
            ps.setString(4, consulta.getData());
            ps.setDouble(5, consulta.getValor());
           

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

    public void alterar(Consulta consulta, String cpf) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tbConsulta SET CPFMedico_Consulta = ?, CPFPaciente_Consulta = ?, Data_Consulta = ?, Valor_Consulta = ? WHERE Codigo_Consulta = ?");

            ps.setString(1, consulta.getMedico().getCpf());
            ps.setString(2, cpf.replace("[^0-9]", ""));
            ps.setString(3, consulta.getData());
            ps.setDouble(4, consulta.getValor());
            ps.setInt(5, consulta.getCodigo());

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

    public Consulta consultar(int codigo) {
        Consulta consulta = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tbConsulta WHERE Codigo_Consulta = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                //VERIFICAR//
                DaoMedico daoMedico = new DaoMedico(conn);

                Medico medico = daoMedico.consultar(rs.getString("CPFMedico_Consulta"));
                
                String cpfPaciente = rs.getString("CPFPaciente_Consulta").replaceAll("[^0-9]", "");

                consulta = new Consulta(rs.getInt("Codigo_Consulta"), rs.getString("Data_Consulta"));
                consulta.setValor(rs.getDouble("Valor_Consulta"));
                consulta.setMedico(medico);
                consulta.setCpfPaciente(cpfPaciente);

                //VERIFICAR//
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

        return consulta;
    }

    public void excluir(Consulta consulta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM tbConsulta WHERE Codigo_Consulta = ?");

            ps.setInt(1, consulta.getCodigo());

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
