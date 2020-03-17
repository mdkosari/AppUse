package com.armiyoon.techhealth.model.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.armiyoon.techhealth.model.database.model.Events;

import java.util.List;

@Dao
public interface EventsDao {

    @Insert
    void insert(Events...events);

    @Update
    void update(Events...events);

    @Delete
    void delete(Events...events);

    @Query("SELECT * FROM events")
    List<Events> getAll();

    @Query("SELECT * FROM events WHERE date=:date AND name=:name")
    List<Events> getByNameAndDate(String name , String date);

    @Query("SELECT * FROM events WHERE date=:date")
    List<Events> getByDate(String date);

    @Query("SELECT * FROM events WHERE name=:name")
    List<Events> getByName(String name);

    @Query("SELECT * FROM events WHERE `set`=:set")
    List<Events> getBySet(boolean set);
}
