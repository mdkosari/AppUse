package com.armiyoon.techhealth.model.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Events {


    public Events(String name,String date, String status, int type, Long length, boolean set) {
        this.name = name;
        this.status = status;
        this.type = type;
        this.length = length;
        this.set = set;
        this.date=date;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String status;
    public int type;
    public Long length;
    public boolean set;
    public String date;


}
