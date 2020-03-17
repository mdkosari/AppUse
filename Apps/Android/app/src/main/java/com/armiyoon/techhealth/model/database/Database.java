package com.armiyoon.techhealth.model.database;

import androidx.room.RoomDatabase;

import com.armiyoon.techhealth.model.database.dao.EventsDao;
import com.armiyoon.techhealth.model.database.dao.ProfileDao;
import com.armiyoon.techhealth.model.database.dao.StatusDao;
import com.armiyoon.techhealth.model.database.model.Events;
import com.armiyoon.techhealth.model.database.model.Profile;
import com.armiyoon.techhealth.model.database.model.Status;

@androidx.room.Database(entities = {Profile.class, Status.class , Events.class},version = 1,exportSchema = false)
abstract class Database extends RoomDatabase {

     abstract ProfileDao profileDao();
     abstract StatusDao statusDao();
     abstract EventsDao eventsDao();
}
