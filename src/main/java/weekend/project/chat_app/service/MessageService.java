package weekend.project.chat_app.service;

import java.util.List;

import weekend.project.chat_app.template.MessageTemplate;
import weekend.project.chat_app.template.ChatRoomTemplate;

public interface MessageService {

    boolean sendMessage(MessageTemplate message);

    List<MessageTemplate> getMessages(ChatRoomTemplate chatRoom);
    
}
