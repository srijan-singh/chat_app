package weekend.project.chat_app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "messages")
public class Message {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    @JsonIgnore
    private ChatRooms chatRoom;

    @ManyToOne // Many messages can be sent by one user
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users sender;

    @Column(name = "message", length = 255)
    private String message;

    @Column(name = "timestamp")
    private Date timestamp;

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public void setID(Long iD) {
        this.messageID = iD;
    }

    public ChatRooms getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRooms chatRoom) {
        this.chatRoom = chatRoom;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    

}
