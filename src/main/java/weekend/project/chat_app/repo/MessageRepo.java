package weekend.project.chat_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import weekend.project.chat_app.entity.Message;
import weekend.project.chat_app.entity.ChatRooms;

import java.util.List;


public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByChatRoom(ChatRooms chatRoom);

}
