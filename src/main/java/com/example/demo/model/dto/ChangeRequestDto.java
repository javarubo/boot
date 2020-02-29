package com.example.demo.model.dto;

public class ChangeRequestDto {




    private String changedcode;

    private String newpassword;

    private String username;


    public String getChangedcode() {
        return changedcode;
    }

    public void setChangedcode(String changedcode) {
        this.changedcode = changedcode;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
