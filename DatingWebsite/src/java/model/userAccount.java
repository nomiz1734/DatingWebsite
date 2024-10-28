package model;

public class userAccount {
    private int id;
    private String username;
    private String fullName;
    private int userTypeId;
    private int genderId;
    private String details;
    private String email;
    private String address;
    private String password;
    private String avatar;
    private String facebook;
    private String status;

    public userAccount(int id, String username, String fullName, int userTypeId, int genderId, String details, String email, String address, String password, String avatar, String facebook, String status) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.userTypeId = userTypeId;
        this.genderId = genderId;
        this.details = details;
        this.email = email;
        this.address = address;
        this.password = password;
        this.avatar = avatar;
        this.facebook = facebook;
        this.status = status;
    }
    
    
    public userAccount(int id, String username, String fullName, int userTypeId, int genderId, String details, String email, String address, String password, String avatar, String facebook) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.userTypeId = userTypeId;
        this.genderId = genderId;
        this.details = details;
        this.email = email;
        this.address = address;
        this.password = password;
        this.avatar = avatar;
        this.facebook = facebook;
    }
    
    public userAccount() {
    }

    public userAccount(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }

    
    
    
    public userAccount(int id, String username, String fullName, int userTypeId, int genderId, String details, String email, String address, String password, String avatar) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.userTypeId = userTypeId;
        this.genderId = genderId;
        this.details = details;
        this.email = email;
        this.address = address;
        this.password = password;
        this.avatar = avatar;
    }
    
    public userAccount(String username, String fullName, int genderId, String details, String address, String avatar, String face) {
        this.username = username;
        this.fullName = fullName;
        this.genderId = genderId;
        this.details = details;
        this.address = address;
        this.avatar = avatar;
        this.facebook = face;
    }

    public userAccount(String username, String fullName, int genderId, String details, String address, String avatar) {
        this.username = username;
        this.fullName = fullName;
        this.genderId = genderId;
        this.details = details;
        this.address = address;
        this.avatar = avatar;
    }

    public userAccount(String username, String fullName, String avatar, String facebook) {
        this.username = username;
        this.fullName = fullName;
        this.avatar = avatar;
        this.facebook = facebook;
    }
    
    public userAccount(String username, String fullName, String facebook) {
        this.username = username;
        this.fullName = fullName;
        this.facebook = facebook;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    

    

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "userAccount{" + "id=" + id + ", username=" + username + ", fullName=" + fullName + ", userTypeId=" + userTypeId + ", genderId=" + genderId + ", details=" + details + ", email=" + email + ", address=" + address + ", password=" + password + ", avatar=" + avatar + '}';
    }
    
    
    
}
