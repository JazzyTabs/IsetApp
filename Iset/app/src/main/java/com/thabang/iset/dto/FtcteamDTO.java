package com.thabang.iset.dto;

/**
 *
 * @author MokomaneMB
 */
public class FtcteamDTO {

    private Integer ftcTeamId;
    private String ftcTeamLocation;
    private String ftcTeamAwards;
    private Integer teamID;

    public FtcteamDTO() {
    }

    public FtcteamDTO(Integer ftcTeamId,  Integer teamID, String ftcTeamLocation, String  ftcTeamAwards) {
        this.ftcTeamId = ftcTeamId;
        this.ftcTeamLocation = ftcTeamLocation;
        this.ftcTeamAwards = ftcTeamAwards;
        this.teamID = teamID;

    }

    public Integer getFtcTeamId() {
        return ftcTeamId;
    }

    public void setFtcTeamId(Integer ftcTeamId) {
        this.ftcTeamId = ftcTeamId;
    }

    public String getFtcTeamLocation() {
        return ftcTeamLocation;
    }

    public void setFtcTeamLocation(String ftcTeamLocation) {
        this.ftcTeamLocation = ftcTeamLocation;
    }

    public String getFtcTeamAwards() {
        return ftcTeamAwards;
    }

    public void setFtcTeamAwards(String ftcTeamAwards) {
        this.ftcTeamAwards = ftcTeamAwards;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

}
