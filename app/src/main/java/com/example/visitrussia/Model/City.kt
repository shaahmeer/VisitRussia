package com.example.visitrussia.Model

import android.os.Parcel
import android.os.Parcelable

data class City(
    var name: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var whatToDo: List<Place>? = null,
    var whatToEat: List<Restaurant>? = null,
    var whereToStay: List<Hotel>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Place.CREATOR),
        parcel.createTypedArrayList(Restaurant.CREATOR),
        parcel.createTypedArrayList(Hotel.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(imageUrl)
        parcel.writeTypedList(whatToDo)
        parcel.writeTypedList(whatToEat)
        parcel.writeTypedList(whereToStay)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }
    }
}
