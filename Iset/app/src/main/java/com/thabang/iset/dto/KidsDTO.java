package com.thabang.iset.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MokomaneMB
 */
public class KidsDTO {

    private Integer kidID;
    private String kidName;
    private String kidLastName;
    private int kidIDNumber;
    private int kidCellNumber;
    private String kidAddress;
    private byte[] kidsProfilePicture;
    private Integer teamID;
    private List<PhotouploadDTO> photouploadList = new ArrayList<>();
    private List<CoachmentorDTO> coachmentorList = new ArrayList<>();

    public KidsDTO() {
    }

    public KidsDTO(Integer kidID, String kidName, String kidLastName, Integer kidIDNumber, Integer kidCellNumber,
                   String kidAddress, byte[] kidsProfilePicture, Integer teamID, List<PhotouploadDTO> photouploadList,
                   List<CoachmentorDTO> coachmentorList) {
        this.kidID = kidID;
        this.kidName = kidName;
        this.kidLastName = kidLastName;
        this.kidIDNumber = kidIDNumber;
        this.kidCellNumber = kidCellNumber;
        this.kidAddress = kidAddress;
        this.kidsProfilePicture = kidsProfilePicture;
        this.teamID = teamID;
        this.photouploadList = photouploadList;
        this.coachmentorList = coachmentorList;
    }

    public Integer getKidID() {
        return kidID;
    }

    public void setKidID(Integer kidID) {
        this.kidID = kidID;
    }

    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }

    public String getKidLastName() {
        return kidLastName;
    }

    public void setKidLastName(String kidLastName) {
        this.kidLastName = kidLastName;
    }

    public int getKidIDNumber() {
        return kidIDNumber;
    }

    public void setKidIDNumber(int kidIDNumber) {
        this.kidIDNumber = kidIDNumber;
    }

    public int getKidCellNumber() {
        return kidCellNumber;
    }

    public void setKidCellNumber(int kidCellNumber) {
        this.kidCellNumber = kidCellNumber;
    }

    public String getKidAddress() {
        return kidAddress;
    }

    public void setKidAddress(String kidAddress) {
        this.kidAddress = kidAddress;
    }

    public byte[] getKidsProfilePicture() {
        return kidsProfilePicture;
    }

    public void setKidsProfilePicture(byte[] kidsProfilePicture) {
        this.kidsProfilePicture = kidsProfilePicture;
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

    public List<CoachmentorDTO> getCoachmentorList() {
        return coachmentorList;
    }

    public void setCoachmentorList(List<CoachmentorDTO> coachmentorList) {
        this.coachmentorList = coachmentorList;
    }

}
