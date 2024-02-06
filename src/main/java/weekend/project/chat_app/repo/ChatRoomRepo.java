package weekend.project.chat_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import weekend.project.chat_app.entity.ChatRooms;

public interface ChatRoomRepo extends JpaRepository<ChatRooms, String> {
   
}
