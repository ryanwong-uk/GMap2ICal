/*
 * Copyright (c) 2022. Ryan Wong (hello@ryanwong.co.uk)
 */

package uk.ryanwong.gmap2ics.data.source.googleapi.models.places

data class Result(
    val address_components: List<uk.ryanwong.gmap2ics.data.source.googleapi.models.places.AddressComponent>? = null,
    val adr_address: String? = null,
    val formatted_address: String,
    val formatted_phone_number: String? = null,
    val geometry: uk.ryanwong.gmap2ics.data.source.googleapi.models.places.Geometry,
    val icon: String? = null,
    val icon_background_color: String? = null,
    val icon_mask_base_uri: String? = null,
    val name: String,
    val place_id: String,
    val plus_code: uk.ryanwong.gmap2ics.data.source.googleapi.models.places.PlusCode? = null,
    val reference: String? = null,
    val types: List<String>,
    val url: String,
    val user_ratings_total: Int? = null,
    val utc_offset: Int? = null,
    val vicinity: String? = null,
    val website: String? = null
)