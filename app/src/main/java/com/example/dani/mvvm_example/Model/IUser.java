package com.example.dani.mvvm_example.Model;

import android.arch.lifecycle.LiveData;

public interface IUser {

    String getName();
    String getPasswd();
    int checkUserValidity(String name, String passwd);
    int getValidity();
}
