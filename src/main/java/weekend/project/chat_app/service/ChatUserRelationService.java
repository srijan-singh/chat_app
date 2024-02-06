package weekend.project.chat_app.service;

import java.util.List;

import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.template.ChatRoomUserTemplate;

public interface ChatUserRelationService {

    // Add User to Chat Room
    boolean addUserToChatRoom(ChatRoomUserTemplate chatRoomUserTemplate);

    List<ChatRooms> getChatRoomsByUserID(String userID);

    List<Users> getUsersByChatID(String chatID);
}
