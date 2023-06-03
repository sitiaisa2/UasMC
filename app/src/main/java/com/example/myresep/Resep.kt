package com.example.myresep

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Resep (
    val R_image : Int,
    val R_title : String,
    val R_des : String
    ): Parcelable