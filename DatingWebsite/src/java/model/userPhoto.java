package model;

public class userPhoto {
    private int id;
    private int userAccountId;
    private String link;

    public userPhoto() {
    }
    
    public userPhoto(int id, int userAccountId, String link) {
        this.id = id;
        this.userAccountId = userAccountId;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
