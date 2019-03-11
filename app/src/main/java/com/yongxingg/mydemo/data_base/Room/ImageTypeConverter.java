package com.yongxingg.mydemo.data_base.Room;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * Created by gaoyongxing on 2018-12-29.
 */
public class ImageTypeConverter {
    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }
}
