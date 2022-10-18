package com.sea.nativealarm.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.sea.nativealarm.model.AlarmDao;
import com.sea.nativealarm.model.AlarmDto;


@androidx.room.Database(entities = {AlarmDto.class}, version = 1, exportSchema = false)
@TypeConverters({RoomTypeConverter.class})
public abstract class Database extends RoomDatabase {
    public abstract AlarmDao alarmDao();
    private static Database instance;

    public static Database getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class,
                    "alarm.db").build();
        }

        return instance;
    }
}
