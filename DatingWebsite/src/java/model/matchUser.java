package model;

public class matchUser {
    private int id;
    private int userAccountId1;
    private int userAccountId2;

    public matchUser() {
    }

    public matchUser(int id, int userAccountId1, int userAccountId2) {
        this.id = id;
        this.userAccountId1 = userAccountId1;
        this.userAccountId2 = userAccountId2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserAccountId1() {
        return userAccountId1;
    }

    public void setUserAccountId1(int userAccountId1) {
        this.userAccountId1 = userAccountId1;
    }

    public int getUserAccountId2() {
        return userAccountId2;
    }

    public void setUserAccountId2(int userAccountId2) {
        this.userAccountId2 = userAccountId2;
    }
    
}
