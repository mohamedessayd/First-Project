package com.example.myapplication33;

import android.widget.EditText;

public class Compte {
    private String email;
    private String password;

    public Compte(){

    }
    public Compte(String email , String password){
        this.email = email;
        this.password = password;
    }
    public boolean isValidCompte(String email , String password){
       if(email.equals(this.email) && password.equals(this.password))
           return true;
       return false;
    }

    public void createNewCompte(String email , String password){
        Compte newCompte = new Compte(email , password);
        DataBase.myComptes.add(newCompte);
    }
}
