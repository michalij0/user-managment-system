import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public void updateUser(User user) throws SQLException {
        userDAO.updateUser(user);
    }

    public void deleteUser(int userId) throws SQLException {
        userDAO.deleteUser(userId);
    }
}