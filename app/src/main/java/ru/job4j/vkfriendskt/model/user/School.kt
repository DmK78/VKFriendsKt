package ru.job4j.vkfriendskt.model.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

data class School(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("country")
    @Expose
    var country: Int? = null,
    @SerializedName("city")
    @Expose
    var city: Int? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("year_from")
    @Expose
    var yearFrom: Int? = null,
    @SerializedName("year_to")
    @Expose
    var yearTo: Int? = null,
    @SerializedName("class")
    @Expose
    var _class: String? = null
) {
    override fun toString(): String {
        var result = StringBuilder()
        result.append(name)
        yearFrom?.let { result.append(", начал в $yearFrom, ") }
        yearTo?.let { result.append("закончил в $yearTo, ") }
        _class?.let { result.append("класс $_class, ") }
        return result.toString()
    }
}