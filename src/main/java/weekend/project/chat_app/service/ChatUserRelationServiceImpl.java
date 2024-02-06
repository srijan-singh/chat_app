package weekend.project.chat_app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.entity.ChatUserRelation;
import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.repo.ChatRoomRepo;
import weekend.project.chat_app.repo.ChatUserRelationRepo;
import weekend.project.chat_app.repo.UserRepo;
import weekend.project.chat_app.template.ChatRoomUserTemplate;

@Repository
public class ChatUserRelationServiceImpl implements ChatUserRelationService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ChatRoomRepo chatRoomRepo;

    @Autowired
    ChatUserRelationRepo chatUserRelationRepo;

    @Override
    public boolean addUserToChatRoom(ChatRoomUserTemplate chatRoomUserTemplate) {

        Users user = userRepo.findByUserID(chatRoomUserTemplate.getUserID());
        ChatRooms chatRoom = chatRoomRepo.findById(chatRoomUserTemplate.getChatID()).orElse(null);

        if (user == null || chatRoom == null) {
            return false;
        }

        ChatUserRelation chatUserRelation = new ChatUserRelation();
        chatUserRelation.setUser(user);
        chatUserRelation.setChatRoom(chatRoom);
        chatUserRelation.setTimestamp(new Date());

        chatUserRelationRepo.save(chatUserRelation);

        return true;
    }

    @Override
    public List<ChatRooms> getChatRoomsByUserID(String userID) {
        List<ChatUserRelation> chatUserRelations = chatUserRelationRepo.findByUser(userRepo.findById(userID));
    
        List<ChatRooms> chatRooms = new ArrayList<>();
        
        for (ChatUserRelation relation : chatUserRelations) {
            chatRooms.add(relation.getChatRoom());
        }
        
        return chatRooms;
    }

    @Override
    public List<Users> getUsersByChatID(String chatID) {
        List<ChatUserRelation> chatUserRelations = chatUserRelationRepo.findByChatRoom(chatRoomRepo.findById(chatID));

        List<Users> users = new ArrayList<>();

        for (ChatUserRelation relation : chatUserRelations) {
            users.add(relation.getUser());
        }

        return users;
    }
}
