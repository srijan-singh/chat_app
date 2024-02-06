package weekend.project.chat_app.service;

import java.util.List;

import weekend.project.chat_app.template.ChatRoomTemplate;

public interface ChatRoomService {

    // Create Chat Room
    boolean createChatRoom(String chatID);

    // Find Chat Room by ID
    ChatRoomTemplate getChatRoomByID(String chatID);

    // ShowAll Chat Rooms
    List<ChatRoomTemplate> showAll();
}
