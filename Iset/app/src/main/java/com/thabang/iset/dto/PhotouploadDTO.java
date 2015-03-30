package com.thabang.iset.dto;



import java.util.Date;

/**
 *
 * @author MokomaneMB
 */
public class PhotouploadDTO {

    private Integer photoUploadID;
    private Date photoDate;
    private byte[] kidPicture;
    private byte[] coachMentorPicture;
    private byte[] eventPicture;
    private byte[] isetrootusersPicture;
    private Integer coachMentorID;
    private Integer eventID;
    private Integer isetRootUsersID;
    private Integer kidID;

    public PhotouploadDTO() {
    }



    public Integer getPhotoUploadID() {
        return photoUploadID;
    }

    public void setPhotoUploadID(Integer photoUploadID) {
        this.photoUploadID = photoUploadID;
    }

    public Date getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(Date photoDate) {
        this.photoDate = photoDate;
    }

    public byte[] getKidPicture() {
        return kidPicture;
    }

    public void setKidPicture(byte[] kidPicture) {
        this.kidPicture = kidPicture;
    }

    public byte[] getCoachMentorPicture() {
        return coachMentorPicture;
    }

    public void setCoachMentorPicture(byte[] coachMentorPicture) {
        this.coachMentorPicture = coachMentorPicture;
    }

    public byte[] getEventPicture() {
        return eventPicture;
    }

    public void setEventPicture(byte[] eventPicture) {
        this.eventPicture = eventPicture;
    }

    public byte[] getIsetrootusersPicture() {
        return isetrootusersPicture;
    }

    public void setIsetrootusersPicture(byte[] isetrootusersPicture) {
        this.isetrootusersPicture = isetrootusersPicture;
    }

    public Integer getCoachMentorID() {
        return coachMentorID;
    }

    public void setCoachMentorID(Integer coachMentorID) {
        this.coachMentorID = coachMentorID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getIsetRootUsersID() {
        return isetRootUsersID;
    }

    public void setIsetRootUsersID(Integer isetRootUsersID) {
        this.isetRootUsersID = isetRootUsersID;
    }

    public Integer getKidID() {
        return kidID;
    }

    public void setKidID(Integer kidID) {
        this.kidID = kidID;
    }

}
