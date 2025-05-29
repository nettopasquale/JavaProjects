/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.ServicoQuarto;
import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class DaoServicoQuarto {
    
    private Connection conn;
    
    public DaoServicoQuarto(Connection coon){
        this.conn =conn;
    }
    
    public void inserir(ServicoQuarto servico){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO tblAluno(Codigo_ServQuarto, "
                    + "Descricao_ServQuarto, "
                    + "Valor_ServQuarto) "
                    + "VALUES(?,?,?)");
            
            ps.setInt(1, servico.getCodigo());
            ps.setString(2, servico.getDescricao());
            ps.setDouble(3, servico.getValor());
                      
            ps.execute(); //envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(ServicoQuarto servico){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE tblServicoQuarto set " + 
                                       "Descricao_ServQuarto = ?, " +
                                       "Valor_ServQuarto = ?, " +
                                       "where Codigo_ServQuarto = ?");
            
            ps.setString(1, servico.getDescricao());
            ps.setDouble(2, servico.getValor());
            ps.setInt(3, servico.getCodigo());
           
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public ServicoQuarto consultar(int codigo){
        ServicoQuarto sq = null;       
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * from tblServicoQuarto "
                    + "where Codigo_ServQuarto = ?");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                sq = new ServicoQuarto(rs.getInt("Codigo_ServQuarto"),
                        rs.getString("Descricao_ServQuarto"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        
        return sq;
    }
    
    public void excluir (ServicoQuarto servico){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM tblServicoAluno"
                    + " where Codigo_ServQuarto = ?");
            
            ps.setInt(1, servico.getCodigo());
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
}
