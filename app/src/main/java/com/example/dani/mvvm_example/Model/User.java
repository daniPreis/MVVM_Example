package com.example.dani.mvvm_example.Model;

import android.arch.lifecycle.LiveData;

public class User implements IUser {
    String name;
    String passwd;
    int userValidity;

    public User(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
        this.userValidity = checkUserValidity(name, passwd);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (name == null || passwd == null || !name.equals(getName()) || !passwd.equals(getPasswd())) {
            return -1;
        }
        return 0;
    }

    @Override
    public int getValidity() {
        return userValidity;
    }
}
