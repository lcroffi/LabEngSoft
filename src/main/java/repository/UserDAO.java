package repository;

import java.util.List;
import model.User;

public interface UserDAO {
    public User insert(User user);
    public User findById(int id);
    public User findByNumeroTitulo(String numeroTitulo);
    public List<User> findAll();
    public void updateAllowVote(int id);
    public void updateDone(int id);
    public boolean delete(User user);
    public boolean delete(int id);     
}