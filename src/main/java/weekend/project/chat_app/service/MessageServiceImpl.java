package weekend.project.chat_app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import weekend.project.chat_app.entity.Message;
import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.entity.ChatUserRelation;
import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.repo.MessageRepo;
import weekend.project.chat_app.repo.ChatRoomRepo;
import weekend.project.chat_app.repo.ChatUserRelationRepo;
import weekend.project.chat_app.repo.UserRepo;
import weekend.project.chat_app.template.MessageTemplate;
import weekend.project.chat_app.template.ChatRoomTemplate;

@Repository
public class MessageServiceImpl implements MessageService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ChatRoomRepo chatRoomRepo;

    @Autowired
    private ChatUserRelationRepo chatUserRelationRepo;

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public boolean sendMessage(MessageTemplate message) {

        Users existingUser = userRepo.findById(message.getSenderID()).orElse(null);
        ChatRooms existingChatRooms = chatRoomRepo.findById(message.getChatRoomID()).orElse(null);

        // If user is not present in chat room
        ChatUserRelation existingChatUserRelation = chatUserRelationRepo.findByChatRoomAndUser(existingChatRooms, existingUser);

        if(existingChatUserRelation == null){
            return false;
        }

        Message chatMessage = new Message();
        chatMessage.setChatRoom(existingChatRooms);
        chatMessage.setSender(existingUser);
        chatMessage.setMessage(message.getMessage());
        chatMessage.setTimestamp(new Date());

        messageRepo.save(chatMessage);
        
        return true;
    }

    @Override
    public List<MessageTemplate> getMessages(ChatRoomTemplate chatRoomTemplate) {
        ChatRooms chatRoom = chatRoomRepo.findById(chatRoomTemplate.getChatID()).orElse(null);

        List<MessageTemplate> messages = new ArrayList<>();

        List <Message> chatMessages = messageRepo.findByChatRoom(chatRoom);

        for(Message message : chatMessages){
            MessageTemplate new_message = new MessageTemplate(message.getChatRoom().getChatID(), message.getSender().getUserID(), message.getMessage());
            new_message.setTimestamp(message.getTimestamp());
            messages.add(new_message);
        }

        return messages;
    }

}
