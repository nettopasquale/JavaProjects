package fatec.poo.control;

import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import fatec.poo.model.Registro;
import fatec.poo.model.ServicoQuarto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author shenmue
 */
public class DaoRegistro {
    
    private Connection conn;
    
    public DaoRegistro(Connection conn) {
        this.conn = conn;
    }
    public Registro consultar(int codigo) {
        Registro registro = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tblRegistro WHERE Codigo_Registro = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                //Eu tava na duvida se a consulta de dao deveria ser feita antes ou depois de next(), mas acho que faz sentido sim acontecer depois da execução 
                // sucedida da query acima.
                DaoRecepcionista daoRecepcionista = new DaoRecepcionista(conn);
                DaoHospede daoHospede = new DaoHospede(conn);
                DaoQuarto daoQuarto = new DaoQuarto(conn);

                Recepcionista recepcionista = daoRecepcionista.consultar(rs.getInt("Recepcionista_Registro"));
                Hospede hospede = daoHospede.consultar(rs.getString("Hospede_Registro"));
                Quarto quarto = daoQuarto.consultar(rs.getInt("Quarto_Registro"));

                registro = new Registro(codigo, rs.getDate("DataEntrada_Registro").toLocalDate(), recepcionista);
                
                //Então, mas ele vai reservar o quarto na consulta? Isso não deveria ser função exclusiva do GUIRegistro?
                registro.reservarQuarto(hospede, quarto);

                //Tinha esquecido da tratativa da data
                if (rs.getDate("DataSaida_Registro") != null) {
                    registro.setDataSaida(rs.getDate("DataSaida_Registro").toLocalDate());
                }

                ps.close();
                rs.close();
                
                ps = conn.prepareStatement("SELECT * FROM tblRegistro_ServicoQuarto WHERE Codigo_Registro_RS = ?");
                ps.setInt(1, codigo);
                rs = ps.executeQuery();

                DaoServicoQuarto daoServicoQuarto = new DaoServicoQuarto(conn);
                while (rs.next()) {
                    ServicoQuarto sq = daoServicoQuarto.consultar(rs.getInt("Codigo_ServQuarto_RS"));
                    registro.addServicos(sq);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar registro: " + ex.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.toString());
            }
        }
        return registro;
    }
    public void inserir(Registro registro) {
        PreparedStatement ps = null;
        try {
            //O método Inserir aqui não precisa do valor final de Hospedagem? Saída também não?
            ps = conn.prepareStatement("INSERT INTO tblRegistro(Codigo_Registro, DataEntrada_Registro, " +
                                           "Recepcionista_Registro, Hospede_Registro, Quarto_Registro) VALUES(?,?,?,?,?)");

            ps.setInt(1, registro.getCodigo());
            ps.setDate(2, Date.valueOf(registro.getDataEntrada()));
            ps.setInt(3, registro.getRecepcionista().getRegFunc());
            //ps.setDate(3, Date.valueOf(registro.getDataSaida()));
            ps.setString(4, registro.getHospede().getCpf());
            ps.setInt(5, registro.getQuarto().getNumero());
            //ps.setDouble(7, registro.getValorHospedagem());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir registro: " + ex.toString());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar PreparedStatement: " + e.toString());
            }
        }
    }
    public void alterar(Registro registro) {
        PreparedStatement ps = null;
        try {
            //DataEntrada, RegFunc de Recepcionista, CPF do Hospede, Código Quarto não podem ser atualizados?
            ps = conn.prepareStatement("UPDATE tblRegistro SET DataSaida_Registro = ?, ValorHospedagem_Registro = ? " +
                                           "WHERE Codigo_Registro = ?");

            if (registro.getDataSaida() != null) ps.setDate(1, Date.valueOf(registro.getDataSaida()));
            else ps.setNull(1, java.sql.Types.DATE); //Boa, n tinha visto a tratativa de data saída

            //ps.setDate(1, Date.valueOf(registro.getDataEntrada()));
            //ps.setInt(3, registro.getRecepcionista().getRegFunc());
            //ps.setString(4, registro.getHospede().getCpf());
            //ps.setInt(5, registro.getQuarto().getNumero());
            ps.setDouble(2, registro.getValorHospedagem());
            ps.setInt(3, registro.getCodigo());
            ps.execute();
            ps.close(); 

            // Sincronizar os serviços de quarto
            // Estratégia: Apagar todos os serviços existentes para este registro e inserir os atuais.
            // Isso garante que a lista no banco seja um espelho da lista no objeto.
            
            // Apaga os serviços antigos
            ps = conn.prepareStatement("DELETE FROM tblRegistro_ServicoQuarto WHERE Codigo_Registro_RS = ?");
            ps.setInt(1, registro.getCodigo());
            ps.execute();
            ps.close();

            // Insere os serviços atuais da lista do objeto
            ps = conn.prepareStatement("INSERT INTO tblRegistro_ServicoQuarto(Codigo_Registro_RS, Codigo_ServQuarto_RS) VALUES (?,?)");
            for (ServicoQuarto servico : registro.getServicos()) {
                ps.setInt(1, registro.getCodigo());
                ps.setInt(2, servico.getCodigo());
                ps.execute();
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar registro: " + ex.toString());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar PreparedStatement: " + e.toString());
            }
        }
    }
    public void excluir(int codigo) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblRegistro_ServicoQuarto WHERE Codigo_Registro_RS = ?");
            ps.setInt(1, codigo);
            ps.execute();
            ps.close();

            ps = conn.prepareStatement("DELETE FROM tblRegistro WHERE Codigo_Registro = ?");
            ps.setInt(1, codigo);
            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir registro: " + ex.toString());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar PreparedStatement: " + e.toString());
            }
        }
    }
    
    // MÉTODO CONSULTAR LISTA DE REGISTROS Eu fiz baseado no projeto de Empresas parte 2, em DaoDepartamentos
    // Eu entendo que a implementação das funções não é a mesma, até pq em departamentos ela era usada para estabelecer
    // conexão do funcionário horista com outros departamentos. 
    // Aqui, consultarRegistros talvez possa servir de tarefa para consultar a lista de hospedes, recepcionistas,
    // quartos e serviços. O meu código não implementou ainda Hóspedes, Quarto e Serviços, acho melhor esperar
    // seu feedback para dar prosseguimento
    public ArrayList<Registro> consultarRegistros(){
        ArrayList<Registro> registros = new ArrayList<>();
        ResultSet rs;
        Recepcionista recepcionista;
        DaoRecepcionista daoRecepcionista = null;
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
