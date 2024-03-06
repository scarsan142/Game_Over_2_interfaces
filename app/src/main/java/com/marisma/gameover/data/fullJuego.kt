package com.marisma.gameover.data

import com.google.gson.annotations.SerializedName

data class FullJuego(
    @SerializedName("aliases") val aliases: List<String>,
    @SerializedName("api_detail_url") val apiDetailUrl: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("concepts") val concepts: List<String>,
    @SerializedName("date_added") val dateAdded: String,
    @SerializedName("date_last_updated") val dateLastUpdated: String,
    @SerializedName("deck") val deck: String,
    @SerializedName("description") val description: String,
    @SerializedName("developers") val developers: List<String>,
    @SerializedName("expected_release_day") val expectedReleaseDay: Int?,
    @SerializedName("expected_release_month") val expectedReleaseMonth: Int?,
    @SerializedName("expected_release_quarter") val expectedReleaseQuarter: Int?,
    @SerializedName("expected_release_year") val expectedReleaseYear: Int?,
    @SerializedName("first_appearance_characters") val firstAppearanceCharacters: List<String>,
    @SerializedName("first_appearance_concepts") val firstAppearanceConcepts: List<String>,
    @SerializedName("first_appearance_locations") val firstAppearanceLocations: List<String>,
    @SerializedName("first_appearance_objects") val firstAppearanceObjects: List<String>,
    @SerializedName("first_appearance_people") val firstAppearancePeople: List<String>,
    @SerializedName("franchises") val franchises: List<String>,
    @SerializedName("genres") val genres: List<String>,
    @SerializedName("guid") val guid: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: Image,
    @SerializedName("killed_characters") val killedCharacters: List<String>,
    @SerializedName("locations") val locations: List<String>,
    @SerializedName("name") val name: String,
    @SerializedName("number_of_user_reviews") val numberOfUserReviews: Int,
    @SerializedName("objects") val objects: List<String>,
    @SerializedName("original_game_rating") val originalGameRating: String,
    @SerializedName("original_release_date") val originalReleaseDate: String,
    @SerializedName("people") val people: List<String>,
    @SerializedName("platforms") val platforms: List<String>,
    @SerializedName("publishers") val publishers: List<String>,
    @SerializedName("releases") val releases: List<String>,
    @SerializedName("dlcs") val dlcs: List<String>,
    @SerializedName("reviews") val reviews: List<String>,
    @SerializedName("similar_games") val similarGames: List<String>,
    @SerializedName("site_detail_url") val siteDetailUrl: String,
    @SerializedName("themes") val themes: List<String>,
    @SerializedName("videos") val videos: List<String>
)

data class Image(
    @SerializedName("icon_url") val iconUrl: String,
    @SerializedName("medium_url") val mediumUrl: String,
    @SerializedName("screen_url") val screenUrl: String,
    @SerializedName("small_url") val smallUrl: String,
    @SerializedName("super_url") val superUrl: String,
    @SerializedName("thumb_url") val thumbUrl: String,
    @SerializedName("tiny_url") val tinyUrl: String,
    @SerializedName("original_url") val originalUrl: String,
    @SerializedName("image_tags") val imageTags: String
)
