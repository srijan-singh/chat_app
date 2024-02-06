package weekend.project.chat_app.template;

import java.util.Date;

public class ChatRoomTemplate {

    private String chatID;
    private Date timestamp;
    
    public ChatRoomTemplate(String chatID, Date timestamp) {
        this.chatID = chatID;
        this.timestamp = timestamp;
    }

    public String getChatID() {
        return chatID;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
