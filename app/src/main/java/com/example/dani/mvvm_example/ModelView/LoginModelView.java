package com.example.dani.mvvm_example.ModelView;


import com.example.dani.mvvm_example.Model.User;
import com.example.dani.mvvm_example.View.IViewListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class LoginModelView {

    public User user;
    private int valid;
    public static final String Property_Valid = "valid";
    private IViewListener listener;

    public LoginModelView() {
        this.listener = null;
        user = new User("","");
    }

    public void doLogin(String name, String passwd) {
        user = new User(name, passwd);
        if (user.getValidity() != 0) valid = -1;
        else valid = 0;


        if(listener != null){
            listener.onAction(valid);
        }

    }

    public void addIViewListener(IViewListener l){
        this.listener = l;
    }

}
