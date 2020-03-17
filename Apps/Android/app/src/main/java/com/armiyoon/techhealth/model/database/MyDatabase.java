package com.armiyoon.techhealth.model.database;

import android.content.Context;
import androidx.room.Room;

import com.armiyoon.techhealth.model.database.model.Events;
import com.armiyoon.techhealth.model.database.model.Profile;
import com.armiyoon.techhealth.model.database.model.Status;

import java.util.List;

public class MyDatabase {

    Context  context;
    Database database;
    public MyDatabase(Context context){
        this.context=context;
        database = Room.databaseBuilder(context, Database.class,"db_alarm").allowMainThreadQueries().build();
    }


    public void setProfile(Profile profile){
        if(database.profileDao().get()!=null)
            database.profileDao().insert(profile);
        else
            database.profileDao().update(profile);
    }
    public void removeProfile(Profile profile){
        database.profileDao().delete(profile);
    }



    public void addStatus(Status...status){
        database.statusDao().insert(status);
    }
    public void deleteStatus(Status...status){
        database.statusDao().delete(status);
    }
    public void updateStatus(Status...status){
        database.statusDao().update(status);
    }
    public List<Status> getAllStatus(){
        return database.statusDao().getAll();
    }
    public List<Status> getByDateStatus(String date){
        return database.statusDao().getByDate(date);
    }
    public List<Status> getByNameStatus(String name){
        return database.statusDao().getByName(name);
    }
    public List<Status> getByNameAndDateStatus(String name , String date){
        return database.statusDao().getByNameAndDate(name,date);
    }
    public List<Status> getBySetStatus(boolean set){
        return database.statusDao().getBySet(set);
    }



    public void addEvents(Events...events){
        database.eventsDao().insert(events);
    }
    public void deleteEvents(Events...events){
        database.eventsDao().delete(events);
    }
    public void updateEvent(Events...events){
        database.eventsDao().update(events);
    }
    public List<Events> getAllEvents(){
        return database.eventsDao().getAll();
    }
    public List<Events> getByDateEvent(String date){
        return database.eventsDao().getByDate(date);
    }
    public List<Events> getByNameEvent(String name){
        return database.eventsDao().getByName(name);
    }
    public List<Events> getByNameAndDateEvent(String date , String name){
        return database.eventsDao().getByNameAndDate(name,date);
    }
    public List<Events> getBySetEvent(boolean set){
        return database.eventsDao().getBySet(set);
    }
}
