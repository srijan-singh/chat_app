package weekend.project.chat_app.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import weekend.project.chat_app.entity.Users;


public interface UserRepo extends JpaRepository<Users, String> {

    Users findByUserID(String userID);

    Users findByUserIDAndPassword(String userId, String Password);
}
