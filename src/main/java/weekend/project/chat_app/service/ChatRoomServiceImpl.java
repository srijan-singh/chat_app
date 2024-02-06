package weekend.project.chat_app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.repo.ChatRoomRepo;

@Repository
public class ChatRoomServiceImpl implements ChatRoomService {

    @Autowired
    private ChatRoomRepo chatRoomRepo;

    @Override
    public boolean createChatRoom(String chatID) {
        Optional<ChatRooms> existingChatRoom = chatRoomRepo.findById(chatID);

        if(existingChatRoom.isPresent()){
            return false;
        }

        ChatRooms chatRoom = new ChatRooms();
        chatRoom.setChatID(chatID);
        chatRoom.setTimestamp(new Date());

        chatRoomRepo.save(chatRoom);

        return true;
    }

    @Override
    public ChatRooms getChatRoomByID(String chatID) {
        return chatRoomRepo.findById(chatID).orElse(null);
    }

    @Override
    public List<ChatRooms> showAll() {
        return chatRoomRepo.findAll();
    }

}
