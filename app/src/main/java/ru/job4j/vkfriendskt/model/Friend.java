package ru.job4j.vkfriendskt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Friend {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("is_closed")
    @Expose
    private Boolean isClosed;
    @SerializedName("can_access_closed")
    @Expose
    private Boolean canAccessClosed;
    @SerializedName("photo_100")
    @Expose
    private String photo100;
    @SerializedName("online")
    @Expose
    private Integer online;
    @SerializedName("track_code")
    @Expose
    private String trackCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Boolean getCanAccessClosed() {
        return canAccessClosed;
    }

    public void setCanAccessClosed(Boolean canAccessClosed) {
        this.canAccessClosed = canAccessClosed;
    }

    public String getPhoto100() {
        return photo100;
    }

    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getTrackCode() {
        return trackCode;
    }

    public void setTrackCode(String trackCode) {
        this.trackCode = trackCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend item = (Friend) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(firstName, item.firstName) &&
                Objects.equals(lastName, item.lastName) &&
                Objects.equals(isClosed, item.isClosed) &&
                Objects.equals(canAccessClosed, item.canAccessClosed) &&
                Objects.equals(photo100, item.photo100) &&
                Objects.equals(online, item.online) &&
                Objects.equals(trackCode, item.trackCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, isClosed, canAccessClosed, photo100, online, trackCode);
    }
}
