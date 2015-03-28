package com.thabang.iset.dto;

import com.thabang.iset.data.Teams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MokomaneMB
 */
public class TeamsDTO {

    private Integer teamID;
    private String teamName;
    private String teamLocation;
    private String teamAwards;
    private String teamRegistration;
    private byte[] teamImage;
    private List<WroteamDTO> wroteamList = new ArrayList<>();
    private List<FtcteamDTO> ftcteamList = new ArrayList<>();
    private List<IsetrootusersDTO> isetrootusersList = new ArrayList<>();
    private List<FllteamDTO> fllteamList = new ArrayList<>();
    private List<KidsDTO> kidsList = new ArrayList<>();

    public TeamsDTO() {
    }

    public TeamsDTO(Teams t) {
        this.teamID = t.getTeamID();
        this.teamName = t.getTeamName();
        this.teamLocation = t.getTeamLocation();
        this.teamAwards = t.getTeamAwards();
        this.teamRegistration = t.getTeamRegistration();
        this.teamImage = t.getTeamImage();

    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(String teamLocation) {
        this.teamLocation = teamLocation;
    }

    public String getTeamAwards() {
        return teamAwards;
    }

    public void setTeamAwards(String teamAwards) {
        this.teamAwards = teamAwards;
    }

    public String getTeamRegistration() {
        return teamRegistration;
    }

    public void setTeamRegistration(String teamRegistration) {
        this.teamRegistration = teamRegistration;
    }

    public byte[] getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(byte[] teamImage) {
        this.teamImage = teamImage;
    }

    public List<WroteamDTO> getWroteamList() {
        return wroteamList;
    }

    public void setWroteamList(List<WroteamDTO> wroteamList) {
        this.wroteamList = wroteamList;
    }

    public List<FtcteamDTO> getFtcteamList() {
        return ftcteamList;
    }

    public void setFtcteamList(List<FtcteamDTO> ftcteamList) {
        this.ftcteamList = ftcteamList;
    }

    public List<IsetrootusersDTO> getIsetrootusersList() {
        return isetrootusersList;
    }

    public void setIsetrootusersList(List<IsetrootusersDTO> isetrootusersList) {
        this.isetrootusersList = isetrootusersList;
    }

    public List<FllteamDTO> getFllteamList() {
        return fllteamList;
    }

    public void setFllteamList(List<FllteamDTO> fllteamList) {
        this.fllteamList = fllteamList;
    }

    public List<KidsDTO> getKidsList() {
        return kidsList;
    }

    public void setKidsList(List<KidsDTO> kidsList) {
        this.kidsList = kidsList;
    }

}
