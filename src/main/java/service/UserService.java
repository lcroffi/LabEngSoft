package service;

import java.text.ParseException;
import java.util.*;

import model.EnumRoles;
import model.Role;
import model.User;
import repository.UserDAO;
import repository.UserDAOMysql;

public class UserService {

    public UserService() throws ParseException {    
    }


    public List<User> findAll() {
        UserDAO uDAO = new UserDAOMysql();
        List<User> users = uDAO.findAll();
        users = setRoles(users);
        return users;
    }

    public List<User> setRoles(List<User> users) {
        List<Role> roles;
        for(User u : users) {
            if (u.getId() == 1) {
                roles = new ArrayList<Role>();
                roles.add(new Role(EnumRoles.CHEFE));
                roles.add(new Role(EnumRoles.MESARIO));
                roles.add(new Role(EnumRoles.USUARIO_COMUM));
                u.setRoles(roles);        
            }
            else if (u.getId() == 2) {
                roles = new ArrayList<Role>();
                roles.add(new Role(EnumRoles.MESARIO));
                roles.add(new Role(EnumRoles.USUARIO_COMUM));
                u.setRoles(roles);        
            }
            else if (u.getId() == 3) {
                roles = new ArrayList<Role>();
                roles.add(new Role(EnumRoles.USUARIO_COMUM));   
                u.setRoles(roles);     
            }
        }
        return users;
    }

    public User findById(int id) {
        UserDAO uDAO = new UserDAOMysql();
        User u = uDAO.findById(id);
        List<Role> roles;
        if (u.getId() == 1) {
            roles = new ArrayList<Role>();
            roles.add(new Role(EnumRoles.CHEFE));
            roles.add(new Role(EnumRoles.MESARIO));
            roles.add(new Role(EnumRoles.USUARIO_COMUM));
            u.setRoles(roles);        
        }
        else if (u.getId() == 2) {
            roles = new ArrayList<Role>();
            roles.add(new Role(EnumRoles.MESARIO));
            roles.add(new Role(EnumRoles.USUARIO_COMUM));
            u.setRoles(roles);        
        }
        else if (u.getId() == 3) {
            roles = new ArrayList<Role>();
            roles.add(new Role(EnumRoles.USUARIO_COMUM));   
            u.setRoles(roles);     
        }
        return u;
    }

    public void AllowVote(int id) {
        UserDAO uDAO = new UserDAOMysql();
        uDAO.updateAllowVote(id);
    }

    public void isDone(int id) {
        UserDAO uDAO = new UserDAOMysql();
        uDAO.updateDone(id);
    }
}