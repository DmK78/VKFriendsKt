package ru.job4j.vkfriendskt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Response {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<Friend> fiends = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Friend> getFiends() {
        return fiends;
    }

    public void setFiends(List<Friend> fiends) {
        this.fiends = fiends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(count, response.count) &&
                Objects.equals(fiends, response.fiends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, fiends);
    }
}