package model;

import java.time.LocalDateTime;

public class message {
    private int id;
    private String userSend;
    private String userReceive;
    private String content;
    private LocalDateTime timestamp;

    public message() {
    }

    public message(String userSend, String userReceive, String content, LocalDateTime timestamp) {
        this.userSend = userSend;
        this.userReceive = userReceive;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserSend() {
        return userSend;
    }

    public void setUserSend(String userSend) {
        this.userSend = userSend;
    }

    public String getUserReceive() {
        return userReceive;
    }

    public void setUserReceive(String userReceive) {
        this.userReceive = userReceive;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "message{" + "id=" + id + ", userSend=" + userSend + ", userReceive=" + userReceive + ", content=" + content + ", timestamp=" + timestamp + '}';
    }
    
    
    
}
