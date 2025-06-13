/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import java.sql.Connection;
import fatec.poo.model.Registro;
import fatec.poo.model.ServicoQuarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Pasquale
 */
public class DaoRegistro {
    private Connection conn;

    public DaoRegistro(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Registro registro){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tblRegistro(Codigo_Registro, "
                    + "DataEntrada_Registro, Recepcionista_Registro, Hospede_Registro, Quarto_Registro) VALUES(?,?,?,?)");
            ps.setInt(1, registro.getCodigo());
            ps.setDate(2, Date.valueOf(registro.getDataEntrada()));
            ps.setInt(3, registro.getRecepcionista().getRegFunc());
            ps.setString(4, registro.getHospede().getCpf());
            ps.setInt(5, registro.getQuarto().getNumero());
        
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }finally{
            try{
                if(ps!= null) ps.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar PreparedStatement: " + e.toString());
            }
        }
    }
    
    public void alterar(Registro registro){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tblRegistro set " + "DataSaida_Registro = ?, " +
                                       "ValorHospedagem_Registro = ?, where Codigo_Registro = ?");
            
            if(registro.getDataSaida() !=null) ps.setDate(1, Date.valueOf(registro.getDataSaida()));
            else ps.setNull(1, java.sql.Types.DATE);

            ps.setDouble(2, registro.getValorHospedagem());
            ps.setInt(3, registro.getCodigo());
            
            ps.execute();
            ps.close();
            
            //sincronizar os servicos de quarto
            
            //apagar os serviços antigos
            ps = conn.prepareStatement("DELETE FROM tblRegistro_ServicoQuarto WHERE Codigo_Registro_RS = ?");
            ps.setInt(1, registro.getCodigo());
            ps.execute();
            ps.close();
            
            //inserir os serviços atuais na lista do objeto
            ps = conn.prepareStatement("INSERT INTO tblRegistro_ServicoQuarto(Codigo_Registro_RS, Codigo_ServQuarto_RS) VALUES (?,?)");
            
            for(ServicoQuarto servico : registro.getServicosQuarto()){
                ps.setInt(1, registro.getCodigo());
                ps.setInt(2, servico.getCodigo());
                ps.execute();
                ps.close();     
            }
        }catch(SQLException ex){
            System.out.println("Erro ao alterar registro: " + ex.toString());
        } finally{
            try{
                if (ps != null) ps.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar PreparedStatement: " + e.toString());
            }
        }
    }
    
    public Registro consultar(int codigo){
        Registro r = null;
        PreparedStatement ps = null;
        Recepcionista recepcionista;
        Hospede hospede;
        Quarto quarto;
        ServicoQuarto servicoQuarto;
        DaoRecepcionista daoRecepcionista = null;
        DaoHospede daoHospede =null;
        DaoQuarto daoQuarto = null;
        DaoServicoQuarto daoServicoQuarto = null;
        int recepcionistaRegFunc;
        ResultSet rs = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM tblRegistro where Codigo_Registro = ?");
            ps.setInt(1, r.getCodigo());
            rs = ps.executeQuery();
           
           if(rs.next()){
           recepcionista = daoRecepcionista.consultar(rs.getInt("Recepcionista_Registro"));
           hospede = daoHospede.consultar(rs.getString("Hospede_Registro"));
           quarto = daoQuarto.consultar(rs.getInt("Quarto_Registro"));

            r = new Registro(codigo, rs.getDate("DataEntrada_Registro").toLocalDate(),recepcionista);
            r.reservarQuarto(hospede, quarto);
            
            if(rs.getDate("DataSaida_Registro")!= null){
                r.setDataSaida(rs.getDate("DataSaida_Registro").toLocalDate());
            }
            
            ps.close();
            rs.close();
            
            ps = conn.prepareStatement("SELECT * FROM tblRegistro_ServicoQuarto WHERE Codigo_Registro_RS = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                servicoQuarto = daoServicoQuarto.consultar(rs.getInt("Codigo_ServQuarto_RS"));
                r.addServicosQuarto(servicoQuarto);
                }
            }
        }catch(SQLException ex){
            System.out.println("Erro ao consultar o registro" + ex.toString());
        }finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                
            }catch(SQLException e){
                System.out.println("Erro ao fechar recursos: " + e.toString());
            }
        }
        
        return r;
    }
    
    public void excluir(Registro registro){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tblRegistro_ServicoQuarto WHERE Codigo_Registro_RS = ?");
            ps.setInt(1, registro.getCodigo());
            ps.execute();
            ps.close();
            
            ps = conn.prepareStatement("DELETE FROM tblRegistro WHERE Codigo_Registro = ?");
            ps.setInt(1, registro.getCodigo());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println("Erro ao excluir registro: " + ex.toString());
        }finally{
            try{
                if(ps!=null) ps.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar PreparedStatement: " + e.toString());
            }
        }
    }
    
    public ArrayList<Registro> consultarRegistros(){
        ArrayList<Registro> registros = new ArrayList<>();
        ResultSet rs = null;
        Recepcionista recepcionista;
        Quarto quarto;
        Hospede hospede;
        ServicoQuarto servicoQuarto;
        DaoRecepcionista daoRecepcionista = null;
        DaoHospede daoHospede = null;
        DaoQuarto daoQuarto = null;
        DaoServicoQuarto daoServicoQuarto = null;
        int recepcionistaRegFunc;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * from tblRegistro order by ");
            
            rs = ps.executeQuery();
            //tentativa de instanciar o objeto Recepcionista para um novo objeto de registro;
            recepcionistaRegFunc = rs.getInt("RegFunc_Recep");
            recepcionista = daoRecepcionista.consultar(recepcionistaRegFunc);
            
            
            while(rs.next()){
                registros.add(new Registro (rs.getInt("Codigo_Registro"), 
                        rs.getDate("DataEntrada_Registro").toLocalDate(), 
                        recepcionista));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return registros;
    }
}
