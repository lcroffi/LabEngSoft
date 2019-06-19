package repository;

import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class UserDAOMysql implements UserDAO{

    Connection conexao;
    
    public UserDAOMysql(){
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
    public User insert(User User) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(int id) {
        User u = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from jpatestdb.users where id = ?");  
            comandoSQLp.setString(1, Integer.toString(id));
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado.");
            rs.next();
            u = new User();
            u.setId(rs.getInt(1));
            u.setNumeroTitulo(rs.getString(2));
            u.setSenha(rs.getString(3));
            u.setNome(rs.getString(4));
            u.setDob(rs.getDate(5));   
            u.setCity(rs.getString(6));
            u.setState(rs.getString(7));   
            u.setEmissaoTitulo(rs.getDate(8));   
            u.setZona(rs.getInt(9));
            u.setSecao(rs.getInt(10));
            u.setAllowVote(rs.getBoolean(11));
            u.setDone(rs.getBoolean(12));
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão: Find by id User ");
        }
        return u;
    }
    
    @Override
    public User findByNumeroTitulo(String numeroTitulo) {
        User u = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from jpatestdb.users where numero_titulo = ?");  
            comandoSQLp.setString(1, numeroTitulo);
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado.");
            rs.next();
            u = new User();
            u.setId(rs.getInt(1));
            u.setNumeroTitulo(rs.getString(2));
            u.setSenha(rs.getString(3));
            u.setNome(rs.getString(4));
            u.setDob(rs.getDate(5));   
            u.setCity(rs.getString(6));
            u.setState(rs.getString(7));   
            u.setEmissaoTitulo(rs.getDate(8));   
            u.setZona(rs.getInt(9));
            u.setSecao(rs.getInt(10));
            u.setAllowVote(rs.getBoolean(11));
            u.setDone(rs.getBoolean(12));           
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão: find by numero_titulo");
        }
        return u;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User u = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from jpatestdb.users");  
            ResultSet rs = comandoSQLp.executeQuery();
            while(rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setNumeroTitulo(rs.getString(2));
                u.setSenha(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setDob(rs.getDate(5));   
                u.setCity(rs.getString(6));
                u.setState(rs.getString(7));   
                u.setEmissaoTitulo(rs.getDate(8));   
                u.setZona(rs.getInt(9));
                u.setSecao(rs.getInt(10));
                u.setAllowVote(rs.getBoolean(11));
                u.setDone(rs.getBoolean(12));
                users.add(u);
            }
            return users;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão: findAll.");
        }
        return users;
    }

    @Override
    public void updateAllowVote(int id) {
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("update jpatestdb.users set allow_vote=? where id=?");  
            comandoSQLp.setBoolean(2, true);
            comandoSQLp.setString(1, Integer.toString(id));

            comandoSQLp.executeUpdate();
            comandoSQLp.close();
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão: updateAllowVote\n");
          System.out.print(e.getMessage());
        }
    }

    @Override
    public void updateDone(int id) {
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("update jpatestdb.users set done=? where id = ?");  
            comandoSQLp.setBoolean(2, true);
            comandoSQLp.setString(1, Integer.toString(id));

            comandoSQLp.executeUpdate();
            comandoSQLp.close();
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão: updateDone");
        }
    }


    @Override
    public boolean delete(User User) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
