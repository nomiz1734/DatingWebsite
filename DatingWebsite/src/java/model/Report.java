/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gamek
 */
public class Report {
    private int id;
    private String username;
    private String username_reported;
    private String reason;

    public Report(int id, String username, String username_reported, String reason) {
        this.id = id;
        this.username = username;
        this.username_reported = username_reported;
        this.reason = reason;
    }

    public Report(String username, String username_reported, String reason) {
        this.username = username;
        this.username_reported = username_reported;
        this.reason = reason;
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

    public String getUsername_reported() {
        return username_reported;
    }

    public void setUsername_reported(String username_reported) {
        this.username_reported = username_reported;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", username=" + username + ", username_reported=" + username_reported + ", reason=" + reason + '}';
    }
    
    
}
