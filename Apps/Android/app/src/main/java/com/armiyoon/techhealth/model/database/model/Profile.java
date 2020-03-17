package com.armiyoon.techhealth.model.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "profile")
public class Profile {


    public Profile(String name, String email, String birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String email;
    public String birth;
}
