package com.armiyoon.techhealth.model.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "status")
public class Status {
    public Status(String name, String status, String date,Long instance, Long used,int pas, boolean set) {
        this.name = name;
        this.status = status;
        this.date = date;
        this.instance=instance;
        this.used = used;
        this.pas=pas;
        this.set = set;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String status;

    public String date;

    public Long instance;

    public int pas;

    public Long used;

    public boolean set;

}
