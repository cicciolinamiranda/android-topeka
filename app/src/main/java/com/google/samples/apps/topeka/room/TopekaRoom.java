package com.google.samples.apps.topeka.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.google.samples.apps.topeka.model.Category;

@Database(entities = {Category.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class TopekaRoom extends RoomDatabase {

    private static final String DB_NAME_ROOM = "topeka_room";
    private static final String DB_SUFFIX = ".db";

    private static TopekaRoom topekaRoom;

    public static TopekaRoom getARoom(Context context) {
        if (topekaRoom == null) {
            topekaRoom = Room.databaseBuilder(context.getApplicationContext(),
                    TopekaRoom.class, DB_NAME_ROOM + DB_SUFFIX).build();
        }

        return topekaRoom;
    }

    public abstract CategoryDao categoryDao();
}
