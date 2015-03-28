package com.thabang.iset.dto;

import com.thabang.iset.data.*;

import java.util.Date;

/**
 *
 * @author MokomaneMB
 */
public class VideosDTO {

    private Integer videoID;
    private String videoName;
    private Date videoDate;
    private Integer isetRootUsersID;

    public VideosDTO() {
    }

    public VideosDTO(Videos v) {
        this.videoID = v.getVideoID();
        this.videoName = v.getVideoName();
        this.videoDate = v.getVideoDate();
        this.isetRootUsersID = v.getIsetRootUsers().getIsetRootUsersID();

    }

    public Integer getVideoID() {
        return videoID;
    }

    public void setVideoID(Integer videoID) {
        this.videoID = videoID;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Date getVideoDate() {
        return videoDate;
    }

    public void setVideoDate(Date videoDate) {
        this.videoDate = videoDate;
    }

    public Integer getIsetRootUsersID() {
        return isetRootUsersID;
    }

    public void setIsetRootUsersID(Integer isetRootUsersID) {
        this.isetRootUsersID = isetRootUsersID;
    }

}
