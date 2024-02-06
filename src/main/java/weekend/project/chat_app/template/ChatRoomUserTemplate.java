package weekend.project.chat_app.template;

public class ChatRoomUserTemplate {

    private String userID;
    private String chatID;

    public ChatRoomUserTemplate(String userID, String chatID) {
        this.userID = userID;
        this.chatID = chatID;
    }
    public String getUserID() {
        return userID;
    }
    public String getChatID() {
        return chatID;
    }

    
    

}
