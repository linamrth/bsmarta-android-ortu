package com.example.lina.userorangtua.Fitur.Login;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context){
        this.context = context;
        prefs = context.getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLogin(boolean login, Integer idorangtua, Integer id){
        editor.putBoolean("login", login);
        editor.putInt("idorangtua", idorangtua);
        editor.putInt("iduser", id);
        editor.commit();
    }

    public boolean login(){
        return prefs.getBoolean("login", false);
    }
}
