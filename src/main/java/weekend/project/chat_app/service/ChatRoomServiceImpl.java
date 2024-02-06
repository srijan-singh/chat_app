package weekend.project.chat_app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.repo.ChatRoomRepo;
import weekend.project.chat_app.template.ChatRoomTemplate;

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
    public ChatRoomTemplate getChatRoomByID(String chatID) {
        ChatRooms chatRoom = chatRoomRepo.findById(chatID).orElse(null);

        if(chatRoom == null){
            return null;
        }

        ChatRoomTemplate chatRoomTemplate = new ChatRoomTemplate(chatRoom.getChatID(), chatRoom.getTimestamp());

        return chatRoomTemplate;
    }

    @Override
    public List<ChatRoomTemplate> showAll() {

        List<ChatRoomTemplate> chatRooms = new ArrayList<>();

        for(ChatRooms chatRoom : chatRoomRepo.findAll()){
            chatRooms.add(new ChatRoomTemplate(chatRoom.getChatID(), chatRoom.getTimestamp()));
        }

        return chatRooms;
    }

}
