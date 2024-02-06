package weekend.project.chat_app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.service.ChatRoomService;

@RestController
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping(value = "chat_room/create", consumes = "application/json")
    public boolean createChatRoom(@RequestBody ChatRooms chatRoom){
        return chatRoomService.createChatRoom(chatRoom.getChatID());
    }

    @GetMapping(value = "chat_room/find/{chatID}", produces = "application/json")
    public ChatRooms finChatRoomsByID(@PathVariable String chatID){
        return chatRoomService.getChatRoomByID(chatID);
    }

    @GetMapping(value = "chat_room/showAll", produces = "application/json")
    public List<ChatRooms> showAllChatRooms(){
        return chatRoomService.showAll();
    }
}
