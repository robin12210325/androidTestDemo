package com.yongxingg.mydemo.data_base.Room;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

/**
 * Created by gaoyongxing on 2018-12-28.
 */
@Database(entities = {NewsInfoEntity.class},version = 1)
@TypeConverters({ImageTypeConverter.class})
public abstract class AppDataBase extends RoomDatabase {

    public abstract NewsInfoDao newsInfoDao();

    private static volatile AppDataBase INSTANCE = null;

    public static AppDataBase getInstance(Context context) {

        if (INSTANCE == null) {

            synchronized (AppDataBase.class) {

                if (INSTANCE == null) {

                    INSTANCE = AppDataBase.buildDatabase(context);

                }

            }

        }

        return INSTANCE;

    }

    private static AppDataBase buildDatabase(Context context) {

        return Room.databaseBuilder(context.getApplicationContext()

                , AppDataBase.class

                , "yongxing.db")

                .build();

    }
//    public abstract CRUDDAO getDao();
@Dao
public interface CRUDDAO {}
public abstract CRUDDAO getDao();


}
