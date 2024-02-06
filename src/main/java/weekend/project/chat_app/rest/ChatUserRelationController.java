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

@RestController
public class ChatUserRelationController {

    @Autowired
    private ChatUserRelationService chatUserRelationService;

    @GetMapping(value = "chat_rooms/{chatID}/add/{userID}", consumes = "application/json")
    public boolean addUserToChatRoom(@PathVariable String chatID, @PathVariable String userID){
        try {

            System.out.println("user:"+userID);
            System.out.println(chatID);
            
            // Rest of your code
            System.out.println("User added to chat room successfully!");
            return chatUserRelationService.addUserToChatRoom(userID, chatID);

            
        } catch (NullPointerException e) {
            // Handle the null pointer exception
            System.out.println("Error: User or ChatRoom is null!");
            return false;
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
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
