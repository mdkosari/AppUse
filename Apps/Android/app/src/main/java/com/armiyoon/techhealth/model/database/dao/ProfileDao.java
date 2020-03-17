package com.armiyoon.techhealth.model.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.armiyoon.techhealth.model.database.model.Profile;

@Dao
public interface ProfileDao {

    @Insert
    void insert(Profile profile);

    @Update
    void update(Profile profile);

    @Delete
    void delete(Profile  profile);

    @Query("SELECT * FROM profile")
    Profile get();
}
