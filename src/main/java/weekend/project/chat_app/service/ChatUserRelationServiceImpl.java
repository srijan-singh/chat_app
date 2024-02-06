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
import weekend.project.chat_app.template.ChatRoomTemplate;
import weekend.project.chat_app.template.ChatRoomUserTemplate;
import weekend.project.chat_app.template.UserTemplate;

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
    public List<ChatRoomTemplate> getChatRoomsByUserID(String userID) {
        List<ChatUserRelation> chatUserRelations = chatUserRelationRepo.findByUser(userRepo.findById(userID));
    
        List<ChatRoomTemplate> chatRooms = new ArrayList<>();
        
        for (ChatUserRelation relation : chatUserRelations) {

            ChatRoomTemplate chatRoom = new ChatRoomTemplate(relation.getChatRoom().getChatID(), relation.getChatRoom().getTimestamp());

            chatRooms.add(chatRoom);
        }
        
        return chatRooms;
    }

    @Override
    public List<UserTemplate> getUsersByChatID(String chatID) {
        List<ChatUserRelation> chatUserRelations = chatUserRelationRepo.findByChatRoom(chatRoomRepo.findById(chatID));

        List<UserTemplate> users = new ArrayList<>();

        for (ChatUserRelation relation : chatUserRelations) {

            UserTemplate user = new UserTemplate(relation.getUser().getUserID());

            users.add(user);
        }

        return users;
    }
}
