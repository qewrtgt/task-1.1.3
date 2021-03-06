package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Билл", "Гейтс", (byte) 65);
        userService.saveUser("Алан", "Тьюринг", (byte) 41);
        userService.saveUser("Линус", "Торвальдс", (byte) 51);
        userService.saveUser("Джеймс", "Гослинг", (byte) 66);
        for(User user : userService.getAllUsers()){
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.disconnectDbJdbc();
    }
}
