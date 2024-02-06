package weekend.project.chat_app.service;

import java.util.List;

import weekend.project.chat_app.template.ChatRoomTemplate;
import weekend.project.chat_app.template.ChatRoomUserTemplate;
import weekend.project.chat_app.template.UserTemplate;

public interface ChatUserRelationService {

    // Add User to Chat Room
    boolean addUserToChatRoom(ChatRoomUserTemplate chatRoomUserTemplate);

    List<ChatRoomTemplate> getChatRoomsByUserID(String userID);

    List<UserTemplate> getUsersByChatID(String chatID);
}
