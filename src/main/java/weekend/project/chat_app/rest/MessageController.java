package weekend.project.chat_app.rest;

import org.springframework.web.bind.annotation.RestController;

import weekend.project.chat_app.service.MessageService;
import weekend.project.chat_app.template.MessageTemplate;
import weekend.project.chat_app.template.ChatRoomTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(value = "chat_rooms/messages/send", consumes = "application/json")
    boolean sendMessageInChatRoom(@RequestBody MessageTemplate messageTemplate){
        return messageService.sendMessage(messageTemplate);
    }

    @PostMapping(value = "chat_rooms/messages", consumes = "application/json", produces = "application/json")
        List<MessageTemplate> getMessages(@RequestBody ChatRoomTemplate chatRoomTemplate){
            return messageService.getMessages(chatRoomTemplate);
        }
    

}
