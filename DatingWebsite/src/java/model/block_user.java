package model;

public class block_user {
    private int id;
    private int userAccountId;
    private int userAccountIdBlocked;

    public block_user() {
    }

    public block_user(int id, int userAccountId, int userAccountIdBlocked) {
        this.id = id;
        this.userAccountId = userAccountId;
        this.userAccountIdBlocked = userAccountIdBlocked;
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

    public int getUserAccountIdBlocked() {
        return userAccountIdBlocked;
    }

    public void setUserAccountIdBlocked(int userAccountIdBlocked) {
        this.userAccountIdBlocked = userAccountIdBlocked;
    }
    
}
