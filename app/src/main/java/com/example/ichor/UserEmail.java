package com.example.ichor;

import android.widget.EditText;

public class UserEmail {

    public String email, pwd , conpwd;

    public UserEmail(EditText email, EditText pass, EditText conpass) {

    }

    public void User(){

    }

    public void User(String email, String pwd, String conpwd){
        this.email = email;
        this.pwd = pwd;
        this.conpwd = conpwd;
        return;
    }

}
