package weekend.project.chat_app.entity;

import java.util.Set;

import javax.persistence.*;

@Entity(name = "Users")
public class Users {

    @Id
    @Column(name = "user_id")
    private String userID;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<ChatUserRelation> chatUserRelation;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ChatUserRelation> getchatUserRelation() {
        return chatUserRelation;
    }

    public void setchatUserRelation(Set<ChatUserRelation> chatUserRelation) {
        this.chatUserRelation = chatUserRelation;
    }

    

}
