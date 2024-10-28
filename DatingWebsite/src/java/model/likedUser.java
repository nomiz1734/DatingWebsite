package model;

public class likedUser {
    private int id;
    private String username;
    private String username_liked;

    public likedUser() {
    }

    public likedUser(int id, String username, String username_liked) {
        this.id = id;
        this.username = username;
        this.username_liked = username_liked;
    }

    public likedUser(String username, String username_liked) {
        this.username = username;
        this.username_liked = username_liked;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_liked() {
        return username_liked;
    }

    public void setUsername_liked(String username_liked) {
        this.username_liked = username_liked;
    }

    @Override
    public String toString() {
        return "likedUser{" + "username=" + username + ", username_liked=" + username_liked + '}';
    }
    

   
    
}
