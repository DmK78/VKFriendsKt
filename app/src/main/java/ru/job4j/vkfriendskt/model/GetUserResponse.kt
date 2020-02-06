package ru.job4j.vkfriendskt.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

class GetUserResponse {
    @SerializedName("response")
    @Expose
    var response: List<User>? = null

    class User {
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("first_name")
        @Expose
        var firstName: String? = null
        @SerializedName("last_name")
        @Expose
        var lastName: String? = null
        @SerializedName("is_closed")
        @Expose
        var isClosed: Boolean? = null
        @SerializedName("can_access_closed")
        @Expose
        var canAccessClosed: Boolean? = null
        @SerializedName("sex")
        @Expose
        var sex: Int? = null
        @SerializedName("nickname")
        @Expose
        var nickname: String? = null
        @SerializedName("maiden_name")
        @Expose
        var maidenName: String? = null
        @SerializedName("domain")
        @Expose
        var domain: String? = null
        @SerializedName("screen_name")
        @Expose
        var screenName: String? = null
        @SerializedName("bdate")
        @Expose
        var bdate: String? = null
        @SerializedName("city")
        @Expose
        var city: City? = null
        @SerializedName("country")
        @Expose
        var country: Country? = null
        @SerializedName("photo_50")
        @Expose
        var photo50: String? = null
        @SerializedName("photo_100")
        @Expose
        var photo100: String? = null
        @SerializedName("photo_200")
        @Expose
        var photo200: String? = null
        @SerializedName("photo_200_orig")
        @Expose
        var photo200Orig: String? = null
        @SerializedName("photo_max")
        @Expose
        var photoMax: String? = null
        @SerializedName("photo_400_orig")
        @Expose
        var photo400Orig: String? = null
        @SerializedName("photo_max_orig")
        @Expose
        var photoMaxOrig: String? = null
        @SerializedName("photo_id")
        @Expose
        var photoId: String? = null
        @SerializedName("has_photo")
        @Expose
        var hasPhoto: Int? = null
        @SerializedName("has_mobile")
        @Expose
        var hasMobile: Int? = null
        @SerializedName("is_friend")
        @Expose
        var isFriend: Int? = null
        @SerializedName("friend_status")
        @Expose
        var friendStatus: Int? = null
        @SerializedName("online")
        @Expose
        var online: Int? = null
        @SerializedName("can_post")
        @Expose
        var canPost: Int? = null
        @SerializedName("can_see_all_posts")
        @Expose
        var canSeeAllPosts: Int? = null
        @SerializedName("can_see_audio")
        @Expose
        var canSeeAudio: Int? = null
        @SerializedName("can_write_private_message")
        @Expose
        var canWritePrivateMessage: Int? = null
        @SerializedName("can_send_friend_request")
        @Expose
        var canSendFriendRequest: Int? = null
        @SerializedName("mobile_phone")
        @Expose
        var mobilePhone: String? = null
        @SerializedName("home_phone")
        @Expose
        var homePhone: String? = null
        @SerializedName("instagram")
        @Expose
        var instagram: String? = null
        @SerializedName("site")
        @Expose
        var site: String? = null
        @SerializedName("status")
        @Expose
        var status: String? = null
        @SerializedName("last_seen")
        @Expose
        var lastSeen: LastSeen? = null
        @SerializedName("crop_photo")
        @Expose
        var cropPhoto: CropPhoto? = null
        @SerializedName("verified")
        @Expose
        var verified: Int? = null
        @SerializedName("can_be_invited_group")
        @Expose
        var canBeInvitedGroup: Boolean? = null
        @SerializedName("followers_count")
        @Expose
        var followersCount: Int? = null
        @SerializedName("blacklisted")
        @Expose
        var blacklisted: Int? = null
        @SerializedName("blacklisted_by_me")
        @Expose
        var blacklistedByMe: Int? = null
        @SerializedName("is_favorite")
        @Expose
        var isFavorite: Int? = null
        @SerializedName("is_hidden_from_feed")
        @Expose
        var isHiddenFromFeed: Int? = null
        @SerializedName("common_count")
        @Expose
        var commonCount: Int? = null
        @SerializedName("occupation")
        @Expose
        var occupation: Occupation? = null
        @SerializedName("career")
        @Expose
        var career: List<Any>? = null
        @SerializedName("military")
        @Expose
        var military: List<Any>? = null
        @SerializedName("university")
        @Expose
        var university: Int? = null
        @SerializedName("university_name")
        @Expose
        var universityName: String? = null
        @SerializedName("faculty")
        @Expose
        var faculty: Int? = null
        @SerializedName("faculty_name")
        @Expose
        var facultyName: String? = null
        @SerializedName("graduation")
        @Expose
        var graduation: Int? = null
        @SerializedName("education_status")
        @Expose
        var educationStatus: String? = null
        @SerializedName("home_town")
        @Expose
        var homeTown: String? = null
        @SerializedName("relation")
        @Expose
        var relation: Int? = null
        @SerializedName("personal")
        @Expose
        var personal: Personal? = null
        @SerializedName("interests")
        @Expose
        var interests: String? = null
        @SerializedName("music")
        @Expose
        var music: String? = null
        @SerializedName("activities")
        @Expose
        var activities: String? = null
        @SerializedName("movies")
        @Expose
        var movies: String? = null
        @SerializedName("tv")
        @Expose
        var tv: String? = null
        @SerializedName("books")
        @Expose
        var books: String? = null
        @SerializedName("games")
        @Expose
        var games: String? = null
        @SerializedName("universities")
        @Expose
        var universities: List<University>? = null
        @SerializedName("schools")
        @Expose
        var schools: List<School>? = null
        @SerializedName("about")
        @Expose
        var about: String? = null
        @SerializedName("relatives")
        @Expose
        var relatives: List<Any>? = null
        @SerializedName("quotes")
        @Expose
        var quotes: String? = null
    }
    class City {
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("title")
        @Expose
        var title: String? = null
    }
    class Country {
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("title")
        @Expose
        var title: String? = null
    }

    class Crop {
        @SerializedName("x")
        @Expose
        var x: Float? = null
        @SerializedName("y")
        @Expose
        var y: Float? = null
        @SerializedName("x2")
        @Expose
        var x2: Float? = null
        @SerializedName("y2")
        @Expose
        var y2: Float? = null
    }

    class CropPhoto {
        @SerializedName("photo")
        @Expose
        var photo: Photo? = null
        @SerializedName("crop")
        @Expose
        var crop: Crop? = null
        @SerializedName("rect")
        @Expose
        var rect: Rect? = null
    }

    class LastSeen {
        @SerializedName("time")
        @Expose
        var time: Int? = null
        @SerializedName("platform")
        @Expose
        var platform: Int? = null
    }

    class Occupation {
        @SerializedName("type")
        @Expose
        var type: String? = null
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
    }
    class Personal {
        @SerializedName("langs")
        @Expose
        var langs: List<String>? = null
        @SerializedName("people_main")
        @Expose
        var peopleMain: Int? = null
        @SerializedName("life_main")
        @Expose
        var lifeMain: Int? = null
        @SerializedName("smoking")
        @Expose
        var smoking: Int? = null
        @SerializedName("alcohol")
        @Expose
        var alcohol: Int? = null
        @SerializedName("religion_id")
        @Expose
        var religionId: Int? = null
    }

    class Photo {
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("album_id")
        @Expose
        var albumId: Int? = null
        @SerializedName("owner_id")
        @Expose
        var ownerId: Int? = null
        @SerializedName("sizes")
        @Expose
        var sizes: List<Size>? = null
        @SerializedName("text")
        @Expose
        var text: String? = null
        @SerializedName("date")
        @Expose
        var date: Int? = null
        @SerializedName("post_id")
        @Expose
        var postId: Int? = null
    }


    class Rect {
        @SerializedName("x")
        @Expose
        var x: Float? = null
        @SerializedName("y")
        @Expose
        var y: Float? = null
        @SerializedName("x2")
        @Expose
        var x2: Float? = null
        @SerializedName("y2")
        @Expose
        var y2: Float? = null
    }
    class School {
        @SerializedName("id")
        @Expose
        var id: String? = null
        @SerializedName("country")
        @Expose
        var country: Int? = null
        @SerializedName("city")
        @Expose
        var city: Int? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("year_from")
        @Expose
        var yearFrom: Int? = null
        @SerializedName("year_to")
        @Expose
        var yearTo: Int? = null
        @SerializedName("class")
        @Expose
        var _class: String? = null

        override fun toString(): String {
            return "$name, Окончил(а) в $yearTo, класс $_class"
        }


    }
    class Size {
        @SerializedName("type")
        @Expose
        var type: String? = null
        @SerializedName("url")
        @Expose
        var url: String? = null
        @SerializedName("width")
        @Expose
        var width: Int? = null
        @SerializedName("height")
        @Expose
        var height: Int? = null
    }
    class University {
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("country")
        @Expose
        var country: Int? = null
        @SerializedName("city")
        @Expose
        var city: Int? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("faculty")
        @Expose
        var faculty: Int? = null
        @SerializedName("faculty_name")
        @Expose
        var facultyName: String? = null
        @SerializedName("chair")
        @Expose
        var chair: Int? = null
        @SerializedName("chair_name")
        @Expose
        var chairName: String? = null
        @SerializedName("graduation")
        @Expose
        var graduation: Int? = null
        @SerializedName("education_status")
        @Expose
        var educationStatus: String? = null
        @SerializedName("education_form")
        @Expose
        var educationForm: String? = null

        override fun toString(): String {
            return "$name, $facultyName, $chairName"
        }


    }
}