package weekend.project.chat_app.template;

import java.util.Date;

public class MessageTemplate {

    private String chatRoomID;
    private String senderID;
    private String message;
    private Date timestamp;

    public MessageTemplate(String chatRoomID, String senderID, String message) {
        this.chatRoomID = chatRoomID;
        this.senderID = senderID;
        this.message = message;
    }

    public String getChatRoomID() {
        return chatRoomID;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getMessage() {
        return message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    

}
