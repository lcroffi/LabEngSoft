package repository;

import model.Candidato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CandidatoDAOMysql implements CandidatoDAO{

    Connection conexao;
    
    public CandidatoDAOMysql(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            /* Abertura de conexão: */
            /* Notar que poderia ser substituida por
            uma chamada de get instance de uma conexão já aberta. 
            */
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/jpatestdb","root", "12345678"); 
            
            System.out.println("Conectado: User DAO.");
        } catch (Exception e){
            System.out.print("Erro de conexão: UserDAOMYSQL\n");
            System.out.print(e.getMessage());
        }
    }
    
    @Override
    public Candidato insert(Candidato Candidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidato findById(int id) {
        Candidato u = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from jpatestdb.candidatos where id = ?");  
            comandoSQLp.setString(1, Integer.toString(id));
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado.");
            rs.next();
            u = new Candidato();
            u.setId(rs.getInt(1));
            u.setFoto(rs.getString(2));
            u.setNomeCandidato(rs.getString(3));
            u.setPartido(rs.getString(4));
            u.setOficio(rs.getString(5));   
            u.setNumeroUrna(rs.getInt(6));
            u.setVotos(rs.getInt(7));
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão: Find by id candidato.");
        }
        return u;
    }
    
    @Override
    public Candidato findByNumeroUrna(int numeroUrna) {
        Candidato u = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from jpatestdb.candidatos where numero_urna = ?");  
            comandoSQLp.setInt(1, numeroUrna);
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado.");
            rs.next();
            u = new Candidato();
            u.setId(rs.getInt(1));
            u.setFoto(rs.getString(2));
            u.setNomeCandidato(rs.getString(3));
            u.setPartido(rs.getString(4));
            u.setOficio(rs.getString(5));   
            u.setNumeroUrna(rs.getInt(6));
            u.setVotos(rs.getInt(7));   
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão: find by numero_urna");
        }
        return u;
    }

    @Override
    public List<Candidato> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidato update(Candidato CandidatoAnt, Candidato CandidatoAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Candidato Candidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
