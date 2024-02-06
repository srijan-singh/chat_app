package weekend.project.chat_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.repo.UserRepo;
import weekend.project.chat_app.template.UserTemplate;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean registration(Users user) {
        Optional<Users> existingUser = userRepo.findById(user.getUserID());

        if(existingUser.isPresent()){
            return false;
        }

        userRepo.save(user);
        return true;
    }

    @Override
    public UserTemplate login(String userID, String password) {
       if(userRepo.findByUserIDAndPassword(userID, password) != null){
            UserTemplate user = new UserTemplate(userID);
            return user;
       }
       return null;
    }

    @Override
    public List<UserTemplate> showAll() {

        List<UserTemplate> users = new ArrayList<>();

        for(Users user : userRepo.findAll()){
            users.add(new UserTemplate(user.getUserID()));
        }

        return users;
    }

}
