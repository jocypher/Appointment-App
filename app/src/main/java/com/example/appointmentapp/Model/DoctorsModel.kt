package com.example.appointmentapp.Model

import android.os.Parcel
import android.os.Parcelable

data class DoctorsModel(
    val Name:String="",
    val Address:String="",
    val Biography:String="",
    val Picture:String="",
    val Id:Int=0,
    val Special:String="",
    val Experience:Int=0,
    val Cost:String="",
    val Date:String="",
    val Time:String="",
    val Location:String="",
    val Mobile:String="",
    val Patients:String="",
    val Ratings:Double=0.0,
    val Site:String=""

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeString(Address)
        parcel.writeString(Biography)
        parcel.writeString(Picture)
        parcel.writeInt(Id)
        parcel.writeString(Special)
        parcel.writeInt(Experience)
        parcel.writeString(Cost)
        parcel.writeString(Date)
        parcel.writeString(Time)
        parcel.writeString(Location)
        parcel.writeString(Mobile)
        parcel.writeString(Patients)
        parcel.writeDouble(Ratings)
        parcel.writeString(Site)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoctorsModel> {
        override fun createFromParcel(parcel: Parcel): DoctorsModel {
            return DoctorsModel(parcel)
        }

        override fun newArray(size: Int): Array<DoctorsModel?> {
            return arrayOfNulls(size)
        }
    }
}
