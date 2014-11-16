package com.swcguild.contactlistmvc.model;
import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private ArrayList<String> authorities = new ArrayList<>();

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<String> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(ArrayList<String> authorities) {
        this.authorities = authorities;
    }
    public void addAuthority(String authority) {
        authorities.add(authority);
    }
}