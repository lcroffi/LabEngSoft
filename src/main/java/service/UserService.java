package service;

import java.text.ParseException;
import java.util.List;

import model.User;

public class UserService {
    private List<User> users;

    public UserService() throws ParseException {    
        DBMockService dbImpl = new DBMockService();
        users = dbImpl.getUsers();   
    }

    public User findById(int id) {
        for(User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }

}