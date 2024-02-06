package weekend.project.chat_app.service;

import java.util.List;

import weekend.project.chat_app.entity.Users;

public interface UserService {

    // User Registration
    boolean registration(Users user);

    // User login
    Users login(String userID, String password);

    // ShowAll
    List<Users> showAll();


}
