package weekend.project.chat_app.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "chat_rooms")
public class ChatRooms {

    @Id
    @Column(name = "chat_id")
    private String chatID;

    @Column(name = "timestamp")
    private Date timestamp;

    @OneToMany(mappedBy = "chatRoom")
    private Set<ChatUserRelation> chatUserRelationship;

    @OneToMany(mappedBy = "chatRoom")
    private Set<Message> messages;

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Set<ChatUserRelation> getChatUserRelationship() {
        return chatUserRelationship;
    }

    public void setChatUserRelationship(Set<ChatUserRelation> chatUserRelationship) {
        this.chatUserRelationship = chatUserRelationship;
    }
    
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

}
