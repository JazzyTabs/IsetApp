package com.thabang.iset.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MokomaneMB
 */
public class EventsDTO  {

    private Integer eventID;
    private String eventName;
    private String eventLocation;
    private Date eventDate;
    private Integer coachMentorID;
    private Integer isetRootUsersID;
    private List<PhotouploadDTO> photouploadList = new ArrayList<>();

    public EventsDTO() {
    }

    public EventsDTO(Integer eventID, String eventName,  String  eventLocation,Date eventDate, Integer coachMentorID, Integer isetRootUsersID,
                     List<PhotouploadDTO> photouploadList) {
        this.eventID = eventID;
        this.eventName =eventName ;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.coachMentorID = coachMentorID;
        this.isetRootUsersID =isetRootUsersID;
        this.photouploadList =photouploadList;

    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getCoachMentorID() {
        return coachMentorID;
    }

    public void setCoachMentorID(Integer coachMentorID) {
        this.coachMentorID = coachMentorID;
    }

    public Integer getIsetRootUsersID() {
        return isetRootUsersID;
    }

    public void setIsetRootUsersID(Integer isetRootUsersID) {
        this.isetRootUsersID = isetRootUsersID;
    }

    public List<PhotouploadDTO> getPhotouploadList() {
        return photouploadList;
    }

    public void setPhotouploadList(List<PhotouploadDTO> photouploadList) {
        this.photouploadList = photouploadList;
    }
}
