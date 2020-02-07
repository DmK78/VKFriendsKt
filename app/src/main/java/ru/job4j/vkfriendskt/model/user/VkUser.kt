package ru.job4j.vkfriendskt.model.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.job4j.vkfriendskt.model.user.*

data class VkUser(
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null,
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null,
    @SerializedName("is_closed")
    @Expose
    var isClosed: Boolean? = null,
    @SerializedName("can_access_closed")
    @Expose
    var canAccessClosed: Boolean? = null,
    @SerializedName("sex")
    @Expose
    var sex: Int? = null,
    @SerializedName("bdate")
    @Expose
    var bdate: String? = null,
    @SerializedName("city")
    @Expose
    var city: City? = null,
    @SerializedName("country")
    @Expose
    var country: Country? = null,
    @SerializedName("photo_100")
    @Expose
    var photo100: String? = null,
    @SerializedName("photo_400_orig")
    @Expose
    var photo400Orig: String? = null,
    @SerializedName("online")
    @Expose
    var online: Int? = null,
    @SerializedName("mobile_phone")
    @Expose
    var mobilePhone: String? = null,
    @SerializedName("home_phone")
    @Expose
    var homePhone: String? = null,
    @SerializedName("status")
    @Expose
    var status: String? = null,
    @SerializedName("last_seen")
    @Expose
    var lastSeen: LastSeen? = null,
    @SerializedName("followers_count")
    @Expose
    var followersCount: Int? = null,
    @SerializedName("university")
    @Expose
    var university: Int? = null,
    @SerializedName("university_name")
    @Expose
    var universityName: String? = null,
    @SerializedName("faculty")
    @Expose
    var faculty: Int? = null,
    @SerializedName("faculty_name")
    @Expose
    var facultyName: String? = null,
    @SerializedName("graduation")
    @Expose
    var graduation: Int? = null,
    @SerializedName("education_status")
    @Expose
    var educationStatus: String? = null,
    @SerializedName("interests")
    @Expose
    var interests: String? = null,
    @SerializedName("universities")
    @Expose
    var universities: List<University>? = null,
    @SerializedName("schools")
    @Expose
    var schools: List<School>? = null,
    @SerializedName("about")
    @Expose
    var about: String? = null
)