package com.thabang.iset.dto;

/**
 *
 * @author MokomaneMB
 */
public class FllteamDTO {

    private Integer fllTeamId;
    private Integer teamID;
    private String fllTeamLocation;
    private String fllTeamAwards;


    public FllteamDTO() {
    }

    public FllteamDTO(Integer fllTeamId,Integer teamID,String fllTeamLocation,String fllTeamAwards) {
        this.fllTeamId = fllTeamId ;
        this.teamID = teamID;
        this.fllTeamLocation = fllTeamLocation;
        this.fllTeamAwards = fllTeamAwards;


    }

    public Integer getFllTeamId() {
        return fllTeamId;
    }

    public void setFllTeamId(Integer fllTeamId) {
        this.fllTeamId = fllTeamId;
    }

    public String getFllTeamLocation() {
        return fllTeamLocation;
    }

    public void setFllTeamLocation(String fllTeamLocation) {
        this.fllTeamLocation = fllTeamLocation;
    }

    public String getFllTeamAwards() {
        return fllTeamAwards;
    }

    public void setFllTeamAwards(String fllTeamAwards) {
        this.fllTeamAwards = fllTeamAwards;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

}
