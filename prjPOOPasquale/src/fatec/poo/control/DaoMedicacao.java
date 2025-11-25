/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pasquale
 */
public class DaoMedicacao {

    private Connection conn;

    public DaoMedicacao(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medicacao medicacao, int codigoConsulta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tbMedicacao(Nome_Medicacao, CodigoConsulta_Medicacao, Dosagem_Medicacao, QtdDias_Medicacao) VALUES(?,?,?,?)");

            ps.setString(1, medicacao.getNome());
            ps.setInt(2, codigoConsulta);
            ps.setString(3, medicacao.getDosagem());
            ps.setInt(4, medicacao.getQtdeDias());

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

    public void alterar(Medicacao medicacao, int codigoConsulta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tbMedicacao SET CodigoConsulta_Medicacao = ?, Dosagem_Medicacao = ?, QtdDias_Medicacao = ? WHERE Nome_Medicacao = ?");

            ps.setInt(1, codigoConsulta);
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setString(4, medicacao.getNome());

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

    public Medicacao consultar(String nome) {
        Medicacao medicacao = null;
        Consulta consulta = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tbMedicacao WHERE Nome_Medicacao = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();

            if (rs.next()) {
                //VERIFICAR

                medicacao = new Medicacao(rs.getString("Nome_Medicacao"));
                int codConsulta = rs.getInt("CodigoConsulta_Medicacao");
                
                medicacao.setDosagem(rs.getString("Dosagem_Medicacao"));
                medicacao.setQtdeDias(rs.getInt("QtdDias_Medicacao"));
                medicacao.setCodigoConsulta(codConsulta);

                //VERIFICAR
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

        return medicacao;
    }

    public void excluir(Medicacao medicacao) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM tbMedicacao WHERE Nome_Medicacao = ?");

            ps.setString(1, medicacao.getNome());

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
