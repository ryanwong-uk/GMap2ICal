/*
 * Copyright (c) 2022. Ryan Wong (hello@ryanwong.co.uk)
 */

package uk.ryanwong.gmap2ics.app

enum class PlaceType {
    ACCOUNTING,
    AIRPORT,
    AMUSEMENT_PARK,
    AQUARIUM,
    ART_GALLERY,
    ATM,
    BAKERY,
    BANK,
    BAR,
    BEAUTY_SALON,
    BICYCLE_STORE,
    BOOK_STORE,
    BOWLING_ALLEY,
    BUS_STATION,
    CAFE,
    CAMPGROUND,
    CAR_DEALER,
    CAR_RENTAL,
    CAR_REPAIR,
    CAR_WASH,
    CASINO,
    CEMETERY,
    CHURCH,
    CITY_HALL,
    CLOTHING_STORE,
    CONVENIENCE_STORE,
    COURTHOUSE,
    DENTIST,
    DEPARTMENT_STORE,
    DOCTOR,
    DRUGSTORE,
    ELECTRICIAN,
    ELECTRONICS_STORE,
    EMBASSY,
    FIRE_STATION,
    FLORIST,
    FUNERAL_HOME,
    FURNITURE_STORE,
    GAS_STATION,
    GROCERY_OR_SUPERMARKET,
    GYM,
    HAIR_CARE,
    HARDWARE_STORE,
    HINDU_TEMPLE,
    HOME_GOODS_STORE,
    HOSPITAL,
    INSURANCE_AGENCY,
    JEWELRY_STORE,
    LAUNDRY,
    LAWYER,
    LIBRARY,
    LIGHT_RAIL_STATION,
    LIQUOR_STORE,
    LOCAL_GOVERNMENT_OFFICE,
    LOCKSMITH,
    LODGING,
    MEAL_DELIVERY,
    MEAL_TAKEAWAY,
    MOSQUE,
    MOVIE_RENTAL,
    MOVIE_THEATER,
    MOVING_COMPANY,
    MUSEUM,
    NATURAL_FEATURE,
    NIGHT_CLUB,
    PAINTER,
    PARK,
    PARKING,
    PET_STORE,
    PHARMACY,
    PHYSIOTHERAPIST,
    PLUMBER,
    POINT_OF_INTEREST,
    POLICE,
    POLITICAL,
    POST_OFFICE,
    PREMISE,
    PRIMARY_SCHOOL,
    REAL_ESTATE_AGENCY,
    RESTAURANT,
    ROOFING_CONTRACTOR,
    RV_PARK,
    SCHOOL,
    SECONDARY_SCHOOL,
    SHOE_STORE,
    SHOPPING_MALL,
    SPA,
    STADIUM,
    STORAGE,
    STORE,
    STREET_ADDRESS,
    SUBWAY_STATION,
    SUPERMARKET,
    SYNAGOGUE,
    TAXI_STAND,
    TOURIST_ATTRACTION,
    TRAIN_STATION,
    TRANSIT_STATION,
    TRAVEL_AGENCY,
    UNIVERSITY,
    VETERINARY_CARE,
    ZOO
}

fun PlaceType.getLabel(): String {
    return when (this) {
        PlaceType.ACCOUNTING -> "๐งพ"
        PlaceType.AIRPORT -> "๐ซ"
        PlaceType.AMUSEMENT_PARK -> "๐ก"
        PlaceType.AQUARIUM -> "๐ "
        PlaceType.ART_GALLERY -> "๐ผ"
        PlaceType.ATM -> "๐ง"
        PlaceType.BAKERY -> "๐"
        PlaceType.BANK -> "๐ฐ"
        PlaceType.BAR -> "๐ท"
        PlaceType.BEAUTY_SALON -> "๐"
        PlaceType.BICYCLE_STORE -> "๐ฒ"
        PlaceType.BOOK_STORE -> "๐"
        PlaceType.BOWLING_ALLEY -> "๐ณ"
        PlaceType.BUS_STATION -> "๐"
        PlaceType.CAFE -> "โ๏ธ"
        PlaceType.CAMPGROUND -> "๐"
        PlaceType.CAR_DEALER -> "๐"
        PlaceType.CAR_RENTAL -> "๐"
        PlaceType.CAR_REPAIR -> "๐จโ๐ง"
        PlaceType.CAR_WASH -> "๐"
        PlaceType.CASINO -> "๐ฐ"
        PlaceType.CEMETERY -> "๐ชฆ"
        PlaceType.CHURCH -> "โช๏ธ"
        PlaceType.CITY_HALL -> "๐"
        PlaceType.CLOTHING_STORE -> "๐"
        PlaceType.CONVENIENCE_STORE -> "๐ช"
        PlaceType.COURTHOUSE -> "โ๏ธ"
        PlaceType.DENTIST -> "๐ฆท"
        PlaceType.DEPARTMENT_STORE -> "๐"
        PlaceType.DOCTOR -> "๐ฉบ"
        PlaceType.DRUGSTORE -> "๐"
        PlaceType.ELECTRICIAN -> "๐จโ๐ง"
        PlaceType.ELECTRONICS_STORE -> "๐"
        PlaceType.EMBASSY -> "๐งณ"
        PlaceType.FIRE_STATION -> "๐ฉโ๐"
        PlaceType.FLORIST -> "๐"
        PlaceType.FUNERAL_HOME -> "โฐ๏ธ"
        PlaceType.FURNITURE_STORE -> "๐ช"
        PlaceType.GAS_STATION -> "โฝ๏ธ"
        PlaceType.GROCERY_OR_SUPERMARKET -> "\uD83D\uDED2"
        PlaceType.GYM -> "๐ช"
        PlaceType.HAIR_CARE -> "๐โโ๏ธ"
        PlaceType.HARDWARE_STORE -> "๐ "
        PlaceType.HINDU_TEMPLE -> "๐"
        PlaceType.HOME_GOODS_STORE -> "๐ชด"
        PlaceType.HOSPITAL -> "๐ฅ"
        PlaceType.INSURANCE_AGENCY -> "๐จโ๐ผ"
        PlaceType.JEWELRY_STORE -> "๐"
        PlaceType.LAUNDRY -> "๐งบ"
        PlaceType.LAWYER -> "โ๏ธ"
        PlaceType.LIBRARY -> "๐"
        PlaceType.LIGHT_RAIL_STATION -> "๐"
        PlaceType.LIQUOR_STORE -> "๐ฅ"
        PlaceType.LOCAL_GOVERNMENT_OFFICE -> "๐ข"
        PlaceType.LOCKSMITH -> "๐"
        PlaceType.LODGING -> "๐จ"
        PlaceType.MEAL_DELIVERY -> "๐ด"
        PlaceType.MEAL_TAKEAWAY -> "๐ฅก"
        PlaceType.MOSQUE -> "๐"
        PlaceType.MOVIE_RENTAL -> "๐"
        PlaceType.MOVIE_THEATER -> "๐ฌ"
        PlaceType.MOVING_COMPANY -> "๐ฆ"
        PlaceType.MUSEUM -> "๐"
        PlaceType.NATURAL_FEATURE -> "๐ฑ"
        PlaceType.NIGHT_CLUB -> "๐ค"
        PlaceType.PAINTER -> "๐จ"
        PlaceType.PARK -> "๐"
        PlaceType.PARKING -> "๐ฟ๏ธ"
        PlaceType.PET_STORE -> "๐ฆฎ"
        PlaceType.PHARMACY -> "๐"
        PlaceType.PHYSIOTHERAPIST -> "๐จโโ๏ธ"
        PlaceType.PLUMBER -> "๐จโ๐ง"
        PlaceType.POINT_OF_INTEREST -> "๐"
        PlaceType.POLICE -> "๐ฎโโ๏ธ"
        PlaceType.POLITICAL -> "๐"
        PlaceType.POST_OFFICE -> "๐ฎ"
        PlaceType.PREMISE -> "๐ข"
        PlaceType.PRIMARY_SCHOOL -> "๐ซ"
        PlaceType.REAL_ESTATE_AGENCY -> "๐ "
        PlaceType.RESTAURANT -> "๐จโ๐ณ"
        PlaceType.ROOFING_CONTRACTOR -> "๐จโ๐ง"
        PlaceType.RV_PARK -> "๐ป"
        PlaceType.SCHOOL -> "๐ซ"
        PlaceType.SECONDARY_SCHOOL -> "๐ซ"
        PlaceType.SHOE_STORE -> "๐"
        PlaceType.SHOPPING_MALL -> "๐ฌ"
        PlaceType.SPA -> "๐งโโ๏ธ"
        PlaceType.STADIUM -> "๐"
        PlaceType.STORAGE -> "๐ฆ"
        PlaceType.STORE -> "๐ฌ"
        PlaceType.STREET_ADDRESS -> "๐ฃ"
        PlaceType.SUBWAY_STATION -> "๐"
        PlaceType.SUPERMARKET -> "๐"
        PlaceType.SYNAGOGUE -> "๐"
        PlaceType.TAXI_STAND -> "๐"
        PlaceType.TOURIST_ATTRACTION -> "๐"
        PlaceType.TRAIN_STATION -> "๐"
        PlaceType.TRANSIT_STATION -> "๐"
        PlaceType.TRAVEL_AGENCY -> "๐"
        PlaceType.UNIVERSITY -> "๐ซ"
        PlaceType.VETERINARY_CARE -> "๐ถ"
        PlaceType.ZOO -> "๐ฆ"
    }
}