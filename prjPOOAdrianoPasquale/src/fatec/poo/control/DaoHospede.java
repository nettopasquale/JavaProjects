/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Hospede;
import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class DaoHospede {
    private Connection conn;
    
    public DaoHospede(Connection coon){
        this.conn =conn;
    }
    
    public void inserir(Hospede hospede){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO tblHospede"
                    + "(Cpf_Hospede, "
                    + "Nome_Hospede, "
                    + "Endereco_Hospede, "
                    + "Telefone_Hospede, "
                    + "TaxaDesconto_Hospede) "
                    + "VALUES(?,?,?,?,?)");
            
            ps.setString(1, hospede.getCpf());
            ps.setString(2, hospede.getNome());
            ps.setString(3, hospede.getEndereco());
            ps.setString(4, hospede.getTelefone());
            ps.setDouble(5, hospede.getTaxaDesconto());
                      
            ps.execute(); //envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Hospede hospede){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE tblHospede set Nome_Hospede = ?, " +
                                       "Endereco_Hospede = ?, " +
                                       "Telefone_Hospede = ? " + 
                                       "TaxaDesconto_Hospede = ? " +
                                       "where Cpf_Hospede = ?");
            
            ps.setString(1, hospede.getNome());
            ps.setString(2, hospede.getEndereco());
            ps.setString(3, hospede.getTelefone());
            ps.setDouble(4, hospede.getTaxaDesconto());
            ps.setString(5, hospede.getCpf());
           
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public Hospede consultar(String cpf){
        Hospede h = null;
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * from tblHospede where Cpf_Hospede = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                h = new Hospede(rs.getString("Nome_Hospede"),rs.getString("Cpf_Hospede"));
                h.setEndereco(rs.getString("Endereco_Hospede"));
                h.setTelefone(rs.getString("Telefone_Hospede"));
                h.setTaxaDesconto(rs.getDouble("TaxaDesconto_Hospede"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        
        return h;
    }
    
    public void excluir (Hospede hospede){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM tblHospede where Cpf_Hospede = ?");
            
            ps.setString(1, hospede.getCpf());
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    
}
