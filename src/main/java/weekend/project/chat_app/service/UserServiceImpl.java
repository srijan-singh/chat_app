package weekend.project.chat_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.repo.UserRepo;

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
    public Users login(String userID, String password) {
       if(userRepo.findByUserIDAndPassword(userID, password) != null){
            return userRepo.findByUserID(userID);
       }
       return null;
    }

    @Override
    public List<Users> showAll() {
        return userRepo.findAll();
    }

}
