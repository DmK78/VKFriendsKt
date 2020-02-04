package ru.job4j.vkfriendskt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class VKUsers {

    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VKUsers vkUsers = (VKUsers) o;
        return Objects.equals(response, vkUsers.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response);
    }
}