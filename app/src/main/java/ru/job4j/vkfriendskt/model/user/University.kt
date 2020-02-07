package ru.job4j.vkfriendskt.model.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

data class University(
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("country")
    @Expose
    var country: Int? = null,
    @SerializedName("city")
    @Expose
    var city: Int? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("faculty")
    @Expose
    var faculty: Int? = null,
    @SerializedName("faculty_name")
    @Expose
    var facultyName: String? = null,
    @SerializedName("chair")
    @Expose
    var chair: Int? = null,
    @SerializedName("chair_name")
    @Expose
    var chairName: String? = null,
    @SerializedName("graduation")
    @Expose
    var graduation: Int? = null,
    @SerializedName("education_status")
    @Expose
    var educationStatus: String? = null,
    @SerializedName("education_form")
    @Expose
    var educationForm: String? = null


) {
    override fun toString(): String {
        var result = StringBuilder()
        result.append(name)
        facultyName?.let { result.append(", $facultyName, ") }
        chairName?.let { result.append("$chairName") }
        return result.toString()
    }
}