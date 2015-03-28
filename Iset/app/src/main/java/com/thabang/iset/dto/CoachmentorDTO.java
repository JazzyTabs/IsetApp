package com.thabang.iset.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MokomaneMB
 */
public class CoachmentorDTO implements Serializable {

    private Integer coachMentorID;
    private Integer kidsID;
    private String coachMentorName;
    private String coachMentorLastName;
    private int coachMentorIDNumber;
    private int coachMentorCellNum;
    private String coachMentorAddress;
    private String coachMentorEmail;
    private List<PhotouploadDTO> photouploadList = new ArrayList<>();
    private List<IsetrootusersDTO> isetrootusersList = new ArrayList<>();
    private List<EventsDTO> eventsList = new ArrayList<>();

    public CoachmentorDTO() {
    }

    public CoachmentorDTO(Integer coachMentorID, Integer kidsID, String coachMentorName, String coachMentorLastName,
                          Integer coachMentorIDNumber, Integer coachMentorCellNum, String coachMentorAddress,
                          String coachMentorEmail, List<PhotouploadDTO> photouploadList, List<IsetrootusersDTO> isetrootusersList,
                          List<EventsDTO> eventsList) {
        this.coachMentorID = coachMentorID;
        this.kidsID = kidsID;
        this.coachMentorName = coachMentorName;
        this.coachMentorLastName = coachMentorLastName;
        this.coachMentorIDNumber = coachMentorIDNumber;
        this.coachMentorCellNum = coachMentorCellNum;
        this.coachMentorAddress = coachMentorAddress;
        this.coachMentorEmail = coachMentorEmail;
        this.photouploadList = photouploadList;
        this.isetrootusersList = isetrootusersList;
        this.eventsList = eventsList;


    }

    public Integer getCoachMentorID() {
        return coachMentorID;
    }

    public void setCoachMentorID(Integer coachMentorID) {
        this.coachMentorID = coachMentorID;
    }

    public String getCoachMentorName() {
        return coachMentorName;
    }

    public void setCoachMentorName(String coachMentorName) {
        this.coachMentorName = coachMentorName;
    }

    public String getCoachMentorLastName() {
        return coachMentorLastName;
    }

    public void setCoachMentorLastName(String coachMentorLastName) {
        this.coachMentorLastName = coachMentorLastName;
    }

    public int getCoachMentorIDNumber() {
        return coachMentorIDNumber;
    }

    public void setCoachMentorIDNumber(int coachMentorIDNumber) {
        this.coachMentorIDNumber = coachMentorIDNumber;
    }

    public int getCoachMentorCellNum() {
        return coachMentorCellNum;
    }

    public void setCoachMentorCellNum(int coachMentorCellNum) {
        this.coachMentorCellNum = coachMentorCellNum;
    }

    public String getCoachMentorAddress() {
        return coachMentorAddress;
    }

    public void setCoachMentorAddress(String coachMentorAddress) {
        this.coachMentorAddress = coachMentorAddress;
    }

    public String getCoachMentorEmail() {
        return coachMentorEmail;
    }

    public void setCoachMentorEmail(String coachMentorEmail) {
        this.coachMentorEmail = coachMentorEmail;
    }

    public Integer getKidsID() {
        return kidsID;
    }

    public void setKidsID(Integer kidsID) {
        this.kidsID = kidsID;
    }

    public List<PhotouploadDTO> getPhotouploadList() {
        return photouploadList;
    }

    public void setPhotouploadList(List<PhotouploadDTO> photouploadList) {
        this.photouploadList = photouploadList;
    }

    public List<IsetrootusersDTO> getIsetrootusersList() {
        return isetrootusersList;
    }

    public void setIsetrootusersList(List<IsetrootusersDTO> isetrootusersList) {
        this.isetrootusersList = isetrootusersList;
    }

    public List<EventsDTO> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventsDTO> eventsList) {
        this.eventsList = eventsList;
    }

}
