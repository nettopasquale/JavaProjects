/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Exame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pasquale
 */
public class DaoExame {

    private Connection conn;

    public DaoExame(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Exame exame) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tbExame (Codigo_Exame, CodigoConsulta_Exame, Descricao_Exame, Data_Exame, Horario_Exame, Valor_Exame) VALUES(?,?,?,?,?,?)");

            ps.setInt(1, exame.getCodigo());
            ps.setInt(2, exame.getConsulta().getCodigo());
            ps.setString(3, exame.getDescricao());
            ps.setString(4, exame.getData());
            ps.setString(5, exame.getHorario());
            ps.setDouble(6, exame.getValor());

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

    public void alterar(Exame exame) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tbExame SET CodigoConsulta_Exame = ?, Descricao_Exame = ?, Data_Exame = ?, Horario_Exame = ?, Valor_Exame = ? WHERE Codigo_Exame = ?");

            ps.setInt(1, exame.getConsulta().getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());
            ps.setInt(6, exame.getCodigo());

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

    public Exame consultar(int codigo) {
        Exame exame = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tbExame WHERE Codigo_Exame = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                //VERIFICAR
                DaoConsulta daoConsulta = new DaoConsulta(conn);
                Consulta consulta = daoConsulta.consultar(rs.getInt("CodigoConsulta_Exame"));
                
                exame = new Exame(rs.getInt("Codigo_Exame"), rs.getString("Descricao_Exame"));
                exame.setData(rs.getString("Data_Exame"));
                exame.setHorario(rs.getString("Horario_Exame"));
                exame.setValor(rs.getDouble("Valor_Exame"));
                exame.setConsulta(consulta);
                
                //VERIFICAR
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return exame;
    }

    public void excluir(Exame exame) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM tbExame WHERE Codigo_Exame = ?");

            ps.setInt(1, exame.getCodigo());

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
