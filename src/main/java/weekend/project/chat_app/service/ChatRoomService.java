package weekend.project.chat_app.service;

import java.util.List;

import weekend.project.chat_app.entity.ChatRooms;

public interface ChatRoomService {

    // Create Chat Room
    boolean createChatRoom(String chatID);

    // Find Chat Room by ID
    ChatRooms getChatRoomByID(String chatID);

    // ShowAll Chat Rooms
    List<ChatRooms> showAll();
}
