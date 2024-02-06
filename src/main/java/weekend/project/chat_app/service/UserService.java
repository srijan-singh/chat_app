package weekend.project.chat_app.service;

import java.util.List;

import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.template.UserTemplate;

public interface UserService {

    // User Registration
    boolean registration(Users user);

    // User login
    UserTemplate login(String userID, String password);

    // ShowAll
    List<UserTemplate> showAll();


}
