package com.thabang.iset.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MokomaneMB
 */
public class IsetrootusersDTO {

    private Integer isetRootUsersID;
    private String isetRootUsersName;
    private String isetRootUsersLastName;
    private int isetRootUsersIDNumber;
    private int isetRootUsersCellNum;
    private String isetRootUsersAddress;
    private String isetRootUsersEmail;
    private Integer coachMentorID;
    private Integer teamID;
    private List<PhotouploadDTO> photouploadList = new ArrayList<>();
    private List<VideosDTO> videosList = new ArrayList<>();
    private List<EventsDTO> eventsList = new ArrayList<>();

    public IsetrootusersDTO(int i, String name, String lastname, int i1, int i2, String address, String email, int i3, int i4) {
    }

    public IsetrootusersDTO(Integer isetRootUsersID, String isetRootUsersName, String isetRootUsersLastName, int isetRootUsersIDNumber, int isetRootUsersCellNum, String isetRootUsersAddress, String isetRootUsersEmail, Integer coachMentorID, Integer teamID, List<PhotouploadDTO> photouploadList, List<VideosDTO> videosList, List<EventsDTO> eventsList) {
        this.isetRootUsersID = isetRootUsersID;
        this.isetRootUsersName = isetRootUsersName;
        this.isetRootUsersLastName = isetRootUsersLastName;
        this.isetRootUsersIDNumber = isetRootUsersIDNumber;
        this.isetRootUsersCellNum = isetRootUsersCellNum;
        this.isetRootUsersAddress = isetRootUsersAddress;
        this.isetRootUsersEmail = isetRootUsersEmail;
        this.coachMentorID = coachMentorID;
        this.teamID = teamID;
        this.photouploadList = photouploadList;
        this.videosList = videosList;
        this.eventsList = eventsList;
    }

    public Integer getIsetRootUsersID() {
        return isetRootUsersID;
    }

    public void setIsetRootUsersID(Integer isetRootUsersID) {
        this.isetRootUsersID = isetRootUsersID;
    }

    public String getIsetRootUsersName() {
        return isetRootUsersName;
    }

    public void setIsetRootUsersName(String isetRootUsersName) {
        this.isetRootUsersName = isetRootUsersName;
    }

    public String getIsetRootUsersLastName() {
        return isetRootUsersLastName;
    }

    public void setIsetRootUsersLastName(String isetRootUsersLastName) {
        this.isetRootUsersLastName = isetRootUsersLastName;
    }

    public int getIsetRootUsersIDNumber() {
        return isetRootUsersIDNumber;
    }

    public void setIsetRootUsersIDNumber(int isetRootUsersIDNumber) {
        this.isetRootUsersIDNumber = isetRootUsersIDNumber;
    }

    public int getIsetRootUsersCellNum() {
        return isetRootUsersCellNum;
    }

    public void setIsetRootUsersCellNum(int isetRootUsersCellNum) {
        this.isetRootUsersCellNum = isetRootUsersCellNum;
    }

    public String getIsetRootUsersAddress() {
        return isetRootUsersAddress;
    }

    public void setIsetRootUsersAddress(String isetRootUsersAddress) {
        this.isetRootUsersAddress = isetRootUsersAddress;
    }

    public String getIsetRootUsersEmail() {
        return isetRootUsersEmail;
    }

    public void setIsetRootUsersEmail(String isetRootUsersEmail) {
        this.isetRootUsersEmail = isetRootUsersEmail;
    }

    public Integer getCoachMentorID() {
        return coachMentorID;
    }

    public void setCoachMentorID(Integer coachMentorID) {
        this.coachMentorID = coachMentorID;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public List<PhotouploadDTO> getPhotouploadList() {
        return photouploadList;
    }

    public void setPhotouploadList(List<PhotouploadDTO> photouploadList) {
        this.photouploadList = photouploadList;
    }

    public List<VideosDTO> getVideosList() {
        return videosList;
    }

    public void setVideosList(List<VideosDTO> videosList) {
        this.videosList = videosList;
    }

    public List<EventsDTO> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventsDTO> eventsList) {
        this.eventsList = eventsList;
    }
}
