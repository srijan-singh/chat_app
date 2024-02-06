package weekend.project.chat_app.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.entity.ChatUserRelation;
import weekend.project.chat_app.entity.Users;

public interface ChatUserRelationRepo extends JpaRepository<ChatUserRelation, Date> {

    ChatUserRelation findByChatRoomAndUser(ChatRooms chatRoom, Users user);

    List<ChatUserRelation> findByChatRoom(Optional<ChatRooms> chatRoom);
    
    List<ChatUserRelation> findByUser(Optional<Users> user);
}
