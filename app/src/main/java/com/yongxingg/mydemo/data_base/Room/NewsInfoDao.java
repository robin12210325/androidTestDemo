package com.yongxingg.mydemo.data_base.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * Created by gaoyongxing on 2018-12-28.
 */
@Dao
public interface NewsInfoDao {
    @Query("SELECT * FROM NewsInfo")
    List<NewsInfoEntity> getNewsInfoList();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NewsInfoEntity[] entity);
}
