package com.yongxingg.mydemo.data_base.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.annotation.NonNull;

/**
 * Created by gaoyongxing on 2018-11-26.
 */
@Entity(tableName = "NewsInfo",primaryKeys = "_id")
public class NewsInfoEntity {
    @NonNull
    @ColumnInfo(name = "_id")
    public String _id;
    @ColumnInfo(name = "createdAt")
    public String createdAt;
    @ColumnInfo(name = "desc")
    public String desc;
    @ColumnInfo(name = "publishedAt")
    public String publishedAt;
    @ColumnInfo(name = "source")
    public String source;
    @ColumnInfo(name = "type")
    public String type;
    @ColumnInfo(name = "url")
    public String url;
    @ColumnInfo(name = "used")
    public boolean used;
    @ColumnInfo(name = "who")
    public String who;
//    @ColumnInfo(name = "images")
//    public List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

//    public List<String> getImages() {
//        return images;
//    }
//
//    public void setImages(List<String> images) {
//        this.images = images;
//    }
}
