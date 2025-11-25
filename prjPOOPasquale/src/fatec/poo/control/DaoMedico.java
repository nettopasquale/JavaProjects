/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pasquale
 */
public class DaoMedico {

    private Connection conn;

    public DaoMedico(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medico medico) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tbMedico(Cpf_Medico, Crm_Medico, Nome_Medico, Endereco_Medico, Telefone_Medico, Especialidade_Medico) VALUES(?,?,?,?,?,?)");

            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getCrm());
            ps.setString(3, medico.getNome());
            ps.setString(4, medico.getEndereco());
            ps.setString(5, medico.getTelefone());
            ps.setString(6, medico.getEspecialidade());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                //evitar NULLPointerException
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public void alterar(Medico medico) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tbMedico SET Crm_Medico = ?, Nome_Medico = ?, Endereco_Medico = ?, Telefone_Medico = ?, Especialidade_Medico = ? WHERE Cpf_Medico = ?");

            ps.setString(1, medico.getCrm());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEndereco());
            ps.setString(4, medico.getTelefone());
            ps.setString(5, medico.getEspecialidade());
            ps.setString(6, medico.getCpf());

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

    public Medico consultar(String cpf) {
        Medico medico = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM tbMedico WHERE Cpf_Medico = ?");
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            if(rs.next()){
                medico = new Medico(rs.getString("Cpf_Medico"),rs.getString("Nome_Medico"),rs.getString("Crm_Medico"),rs.getString("Especialidade_Medico"));
                medico.setEndereco(rs.getString("Endereco_Medico"));
                medico.setTelefone(rs.getString("Telefone_Medico"));
            }
        
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }finally{
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
        return medico;
    }

    public void excluir(Medico medico) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM tbMedico WHERE Cpf_Medico = ?");
            ps.setString(1, medico.getCpf());

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
