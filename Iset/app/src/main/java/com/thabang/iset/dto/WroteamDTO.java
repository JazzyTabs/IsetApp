package com.thabang.iset.dto;

/**
 *
 * @author MokomaneMB
 */
public class WroteamDTO {

    private Integer wroTeamID;
    private String wroTeamLocation;
    private String wroTeamCompetition;
    private Integer teamID;

    public WroteamDTO() {
    }

    public WroteamDTO(Integer wroTeamID, String wroTeamLocation, String wroTeamCompetition, Integer teamID) {
        this.wroTeamID = wroTeamID;
        this.wroTeamLocation = wroTeamLocation;
        this.wroTeamCompetition = wroTeamCompetition;
        this.teamID = teamID;
    }

    public Integer getWroTeamID() {
        return wroTeamID;
    }

    public void setWroTeamID(Integer wroTeamID) {
        this.wroTeamID = wroTeamID;
    }

    public String getWroTeamLocation() {
        return wroTeamLocation;
    }

    public void setWroTeamLocation(String wroTeamLocation) {
        this.wroTeamLocation = wroTeamLocation;
    }

    public String getWroTeamCompetition() {
        return wroTeamCompetition;
    }

    public void setWroTeamCompetition(String wroTeamCompetition) {
        this.wroTeamCompetition = wroTeamCompetition;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }
}
