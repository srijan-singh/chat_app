package weekend.project.chat_app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import weekend.project.chat_app.entity.ChatRooms;
import weekend.project.chat_app.entity.ChatUserRelation;
import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.service.ChatUserRelationService;
import weekend.project.chat_app.template.ChatRoomUserTemplate;

@RestController
public class ChatUserRelationController {

    @Autowired
    private ChatUserRelationService chatUserRelationService;

    @PostMapping(value = "chat_rooms/add/user", consumes = "application/json")
    public boolean addUserToChatRoom(@RequestBody ChatRoomUserTemplate chatRoomUserTemplate){
        return chatUserRelationService.addUserToChatRoom(chatRoomUserTemplate);
    }

    @GetMapping(value = "chat_room/users/{chatID}", produces = "application/json")
    public List<Users> getUsersByChatID(@PathVariable String chatID){
        return chatUserRelationService.getUsersByChatID(chatID);
    }
    
    @GetMapping(value = "users/chat_room/{userID}", produces = "application/json")
    public List<ChatRooms> getChatRoomsByUserID(@PathVariable String userID){
        return chatUserRelationService.getChatRoomsByUserID(userID);
    }

}
