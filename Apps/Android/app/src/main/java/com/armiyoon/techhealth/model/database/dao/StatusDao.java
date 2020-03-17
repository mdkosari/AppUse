package com.armiyoon.techhealth.model.database.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.armiyoon.techhealth.model.database.model.Status;

import java.util.List;

@Dao
public interface StatusDao {

    @Insert
    void insert(Status...status);

    @Update
    void update(Status...status);

    @Delete
    void delete(Status...status);

    @Query("SELECT * FROM status")
    List<Status> getAll();

    @Query("SELECT * FROM status WHERE date=:date AND name=:name")
    List<Status> getByNameAndDate(String name , String date);

    @Query("SELECT * FROM status WHERE date=:date")
    List<Status> getByDate(String date);

    @Query("SELECT * FROM status WHERE name=:name")
    List<Status> getByName(String name);

    @Query("SELECT * FROM status WHERE `set`=:set")
    List<Status> getBySet(boolean set);

}
